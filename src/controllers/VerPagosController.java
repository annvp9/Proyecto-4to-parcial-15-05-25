package controllers;

import dao.PagoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Pago;

public class VerPagosController {

    @FXML
    private TableView<Pago> tablePagos;

    @FXML
    private TableColumn<Pago, Integer> colIdPago;

    @FXML
    private TableColumn<Pago, Integer> colIdReserva;

    @FXML
    private TableColumn<Pago, Double> colMonto;

    @FXML
    private TableColumn<Pago, String> colMetodoPago;

    @FXML
    private TableColumn<Pago, String> colFechaPago;

    @FXML
    public void initialize() {
        colIdPago.setCellValueFactory(new PropertyValueFactory<>("idPago"));
        colIdReserva.setCellValueFactory(new PropertyValueFactory<>("idReserva"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        colMetodoPago.setCellValueFactory(new PropertyValueFactory<>("metodoPago"));
        colFechaPago.setCellValueFactory(new PropertyValueFactory<>("fechaPago"));

        cargarPagos();
    }

    private void cargarPagos() {
        try {
            ObservableList<Pago> pagos = FXCollections.observableArrayList(PagoDAO.obtenerTodos());
            tablePagos.setItems(pagos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


