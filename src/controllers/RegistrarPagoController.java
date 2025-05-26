package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import models.Pago;
import dao.PagoDAO;

public class RegistrarPagoController {

    @FXML
    private ComboBox<String> tipoEstacionamientoComboBox;
    @FXML
    private TextField horasEstacionadasField;
    @FXML
    private TextField metodoPagoField;


    @FXML
    public void registrarPago(ActionEvent event) {
        try {
            String tipoEstacionamiento = tipoEstacionamientoComboBox.getValue();
            String metodoPago = metodoPagoField.getText();

            if ("temporal".equalsIgnoreCase(tipoEstacionamiento)) {
                double horasEstacionadas = Double.parseDouble(horasEstacionadasField.getText());
                Pago pago = new Pago(tipoEstacionamiento, horasEstacionadas, metodoPago);

                if (PagoDAO.insertarPago(pago)) {
                    mostrarMensaje("Pago registrado exitosamente", "Monto: $" + pago.getMonto());
                } else {
                    mostrarMensajeError("No se pudo registrar el pago.");
                }
            } else if ("pension".equalsIgnoreCase(tipoEstacionamiento)) {
                Pago pago = new Pago(tipoEstacionamiento, metodoPago);

                if (PagoDAO.insertarPago(pago)) {
                    mostrarMensaje("Pago registrado exitosamente", "Monto mensual: $" + pago.getMonto());
                } else {
                    mostrarMensajeError("No se pudo registrar el pago.");
                }
            } else {
                mostrarMensajeError("Seleccione un tipo de estacionamiento válido");
            }
        } catch (NumberFormatException e) {
            mostrarMensajeError("Por favor ingrese un valor válido para las horas.");
        }
    }

    private void mostrarMensaje(String titulo, String contenido) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarMensajeError(String contenido) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    @FXML
    public void volverAlMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage) tipoEstacionamientoComboBox.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
