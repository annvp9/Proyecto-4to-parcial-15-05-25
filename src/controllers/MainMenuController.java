package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class MainMenuController {

    @FXML
    public void irRegistrarCliente(ActionEvent event) {
        cargarEscena(event, "/View/registrar_cliente.fxml");
    }

    @FXML
    public void irRegistrarVehiculo(ActionEvent event) {
        cargarEscena(event, "/View/registrar_vehiculo.fxml");
    }

    @FXML
    public void irRegistrarReserva(ActionEvent event) {
        cargarEscena(event, "/View/registrar_reserva.fxml");
    }

    @FXML
    public void irRegistrarPago(ActionEvent event) {
        cargarEscena(event, "/View/registrar_pago.fxml");
    }

    @FXML
    public void irVerClientes(ActionEvent event) {
        cargarEscena(event, "/View/ver_clientes.fxml");
    }

    @FXML
    public void irVerVehiculos(ActionEvent event) {
        cargarEscena(event, "/View/ver_vehiculos.fxml");
    }

    @FXML
    public void irVerReservas(ActionEvent event) {
        cargarEscena(event, "/View/ver_reservas.fxml");
    }

    @FXML
    public void irVerPagos(ActionEvent event) {
        cargarEscena(event, "/View/ver_pagos.fxml");
    }

    private void cargarEscena(ActionEvent event, String rutaFXML) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(rutaFXML));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
    }
}
