package controllers;

import dao.ClienteDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Cliente;

public class RegistrarClienteController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtDireccion;
    @FXML private Label lblMensaje;

    @FXML
    public void registrarCliente() {
        try {
            // Validar campos vacíos
            if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() ||
                    txtCorreo.getText().isEmpty() || txtTelefono.getText().isEmpty() ||
                    txtDireccion.getText().isEmpty()) {

                lblMensaje.setText("Todos los campos son obligatorios.");
                return;
            }

            // Validar correo duplicado
            if (ClienteDAO.existeCorreo(txtCorreo.getText().trim())) {
                lblMensaje.setText("El correo ya está registrado.");
                return;
            }

            Cliente cliente = new Cliente(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtCorreo.getText(),
                    txtTelefono.getText(),
                    txtDireccion.getText(),
                    "1234"
            );

            boolean registrado = ClienteDAO.registrarCliente(cliente);

            if (registrado) {
                lblMensaje.setText("¡Cliente registrado exitosamente!");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ver_clientes.fxml"));
                Parent root = loader.load();

                VerClientesController controller = loader.getController();
                controller.cargarClientes();

                Stage stage = (Stage) txtNombre.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                lblMensaje.setText("No se pudo registrar el cliente.");
            }

        } catch (Exception e) {
            lblMensaje.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void volverAlMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage) txtNombre.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

