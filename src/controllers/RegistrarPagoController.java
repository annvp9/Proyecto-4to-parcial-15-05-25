package controllers;

import dao.PagoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import models.Pago;
import java.time.LocalDateTime;

public class RegistrarPagoController {
    @FXML private TextField txtIdReserva, txtMonto, txtMetodo, txtFecha;
    @FXML private Label lblMensaje;

    @FXML
    public void registrarPago() {
        try {
            Pago pago = new Pago(
                    Integer.parseInt(txtIdReserva.getText()),
                    Double.parseDouble(txtMonto.getText()),
                    txtMetodo.getText(),
                    LocalDateTime.parse(txtFecha.getText())
            );
            PagoDAO.insertarPago(pago);
            lblMensaje.setText("Pago registrado correctamente");
        } catch (Exception e) {
            lblMensaje.setText("Error: " + e.getMessage());
        }
    }
}
