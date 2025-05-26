package controllers;

import dao.ReservaDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Reserva;

import java.util.List;

public class VerReservasController {

    @FXML private TableView<Reserva> tableReservas;
    @FXML private TableColumn<Reserva, Integer> colIdReserva;
    @FXML private TableColumn<Reserva, Integer> colIdCliente;
    @FXML private TableColumn<Reserva, String> colFechaInicio;
    @FXML private TableColumn<Reserva, String> colFechaFin;
    @FXML private TableColumn<Reserva, String> colEstado;

    @FXML
    public void initialize() {
        colIdReserva.setCellValueFactory(new PropertyValueFactory<>("idReserva"));
        colIdCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));

        colFechaInicio.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFechaInicio().toString())
        );

        colFechaFin.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFechaFin().toString())
        );

        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        cargarReservas();
    }

    private void cargarReservas() {
        try {
            List<Reserva> lista = ReservaDAO.obtenerTodos();
            ObservableList<Reserva> data = FXCollections.observableArrayList(lista);
            tableReservas.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
