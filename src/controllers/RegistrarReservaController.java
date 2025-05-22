package controllers;

import dao.ReservaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import models.Reserva;
import java.time.LocalDateTime;

public class RegistrarReservaController {
    @FXML private TextField txtIdCliente, txtIdEspacio, txtIdTarifa, txtInicio, txtFin, txtEstado;
    @FXML private Label lblMensaje;

    @FXML
    public void registrarReserva() {
        try {
            Reserva r = new Reserva(
                    Integer.parseInt(txtIdCliente.getText()),
                    Integer.parseInt(txtIdEspacio.getText()),
                    Integer.parseInt(txtIdTarifa.getText()),
                    LocalDateTime.parse(txtInicio.getText()),
                    LocalDateTime.parse(txtFin.getText()),
                    txtEstado.getText()
            );
            ReservaDAO.insertarReserva(r);
            lblMensaje.setText("Reserva registrada exitosamente");
        } catch (Exception e) {
            lblMensaje.setText("Error: " + e.getMessage());
        }
    }
}