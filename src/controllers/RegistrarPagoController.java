package controllers;

import dao.PagoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Pago;

import java.time.LocalDate;

public class RegistrarPagoController {

    @FXML
    private TextField txtIdReserva;

    @FXML
    private TextField txtMonto;

    @FXML
    private TextField txtMetodoPago;

    @FXML
    private TextField txtTipoEstacionamiento;

    @FXML
    private DatePicker dpFechaPago;

    @FXML
    public void registrarPago() {
        try {
            int idReserva = Integer.parseInt(txtIdReserva.getText().trim());
            double monto = Double.parseDouble(txtMonto.getText().trim());
            String metodoPago = txtMetodoPago.getText().trim();
            String tipoEstacionamiento = txtTipoEstacionamiento.getText().trim();
            LocalDate fechaPago = dpFechaPago.getValue();

            if (metodoPago.isEmpty() || tipoEstacionamiento.isEmpty() || fechaPago == null) {
                mostrarAlerta("Error", "Por favor completa todos los campos.");
                return;
            }

            Pago pago = new Pago(idReserva, monto, metodoPago, tipoEstacionamiento, fechaPago);

            boolean exito = PagoDAO.insertarPago(pago);

            if (exito) {
                mostrarAlerta("Éxito", "Pago registrado correctamente.");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar el pago.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de reserva y monto deben ser números válidos.");
        } catch (Exception e) {
            mostrarAlerta("Error", "Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        txtIdReserva.clear();
        txtMonto.clear();
        txtMetodoPago.clear();
        txtTipoEstacionamiento.clear();
        dpFechaPago.setValue(null);
    }

    public void volverAlMenu(ActionEvent actionEvent) {
    }
}
