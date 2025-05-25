package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class RegistrarPagoController {

    @FXML private TextField txtIdReserva, txtMonto, txtMetodoPago;
    @FXML private Label lblMensaje;

    @FXML
    public void registrarPago() {

        lblMensaje.setText("Pago registrado con éxito");
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

