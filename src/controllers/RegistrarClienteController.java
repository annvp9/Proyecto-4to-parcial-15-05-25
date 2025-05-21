package controllers;

import dao.ClienteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import models.Cliente;

public class RegistrarClienteController {
    @FXML private TextField txtNombre, txtApellido, txtCorreo, txtTelefono, txtDireccion;
    @FXML private Label lblMensaje;

    @FXML
    public void registrarCliente() {
        try {
            Cliente cliente = new Cliente(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtCorreo.getText(),
                    txtTelefono.getText(),
                    txtDireccion.getText()
            );
            ClienteDAO.insertarCliente(cliente);
            lblMensaje.setText("¡Cliente registrado exitosamente!");
        } catch (Exception e) {
            lblMensaje.setText("Error: " + e.getMessage());
        }
    }
}
