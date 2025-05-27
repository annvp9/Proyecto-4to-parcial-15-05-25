package controllers;

import dao.PagoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.time.LocalDate;
import java.time.LocalDateTime;
import models.Pago;

public class RegistrarPagoController {

    @FXML
    private TextField txtIdReserva;

    @FXML
    private TextField txtMonto;

    @FXML
    private TextField txtMetodoPago;

    @FXML
    private DatePicker dateFechaPago;

    @FXML
    public void registrarPago(ActionEvent event) {
        try {
            if (txtIdReserva.getText().isEmpty() || txtMonto.getText().isEmpty() ||
                    txtMetodoPago.getText().isEmpty() || dateFechaPago.getValue() == null) {
                mostrarAlerta("Error", "Por favor, llena todos los campos obligatorios");
                return;
            }

            int idReserva = Integer.parseInt(txtIdReserva.getText());
            double monto = Double.parseDouble(txtMonto.getText());
            String metodoPago = txtMetodoPago.getText();

            LocalDate localDate = dateFechaPago.getValue();
            LocalDateTime fechaPago = localDate.atStartOfDay();

            Pago pago = new Pago(idReserva, monto, metodoPago, fechaPago);

            boolean resultado = PagoDAO.insertarPago(pago);

            if (resultado) {
                mostrarAlerta("Éxito", "Pago registrado correctamente");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar el pago. Verifica los datos.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Formato de número inválido");
        } catch (Exception e) {
            mostrarAlerta("Error", "Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void volverAlMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo regresar al menú");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        txtIdReserva.clear();
        txtMonto.clear();
        txtMetodoPago.clear();
        dateFechaPago.setValue(null);
    }
}
