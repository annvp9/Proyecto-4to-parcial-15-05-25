package controllers;

import dao.VehiculoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import models.Vehiculo;


public class RegistrarVehiculoController {
    @FXML private TextField txtIdCliente, txtPlaca, txtMarca, txtModelo, txtColor, txtTipo;
    @FXML private Label lblMensaje;

    @FXML
    public void registrarVehiculo() {
        try {
            Vehiculo v = new Vehiculo(
                    Integer.parseInt(txtIdCliente.getText()),
                    txtPlaca.getText(),
                    txtMarca.getText(),
                    txtModelo.getText(),
                    txtColor.getText(),
                    txtTipo.getText()
            );
            VehiculoDAO.insertarVehiculo(v);
            lblMensaje.setText("Vehículo registrado exitosamente");
        } catch (Exception e) {
            lblMensaje.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    public void volverAlMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage) lblMensaje.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println("Error al cargar menú: " + e.getMessage());
        }
    }
}


