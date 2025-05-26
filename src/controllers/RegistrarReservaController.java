package controllers;

import dao.ReservaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import models.Reserva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RegistrarReservaController {

    @FXML private TextField txtIdCliente;
    @FXML private DatePicker dpFechaInicio;
    @FXML private DatePicker dpFechaFin;
    @FXML private TextField txtEstado;
    @FXML private Label lblMensaje;

    @FXML
    public void registrarReserva() {
        try {
            if (txtIdCliente.getText().isEmpty() ||
                    dpFechaInicio.getValue() == null || dpFechaFin.getValue() == null || txtEstado.getText().isEmpty()) {
                lblMensaje.setText("Todos los campos son obligatorios.");
                return;
            }

            int idCliente = Integer.parseInt(txtIdCliente.getText().trim());

            if (!ReservaDAO.existeCliente(idCliente)) {
                lblMensaje.setText("El cliente no existe.");
                return;
            }

            LocalDate inicioDate = dpFechaInicio.getValue();
            LocalDate finDate = dpFechaFin.getValue();

            LocalDateTime fechaInicio = inicioDate.atTime(LocalTime.MIN);
            LocalDateTime fechaFin = finDate.atTime(LocalTime.MIN);

            String estado = txtEstado.getText().trim();

            Reserva reserva = new Reserva(0, idCliente, fechaInicio, fechaFin, estado);

            boolean registrado = ReservaDAO.insertarReserva(reserva);

            if (registrado) {
                lblMensaje.setText("Reserva registrada correctamente.");
                limpiarCampos();
            } else {
                lblMensaje.setText("Error al registrar la reserva.");
            }
        } catch (NumberFormatException e) {
            lblMensaje.setText("Los IDs deben ser números válidos.");
        } catch (Exception e) {
            lblMensaje.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        txtIdCliente.clear();
        dpFechaInicio.setValue(null);
        dpFechaFin.setValue(null);
        txtEstado.clear();
    }

    @FXML
    public void volverAlMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
