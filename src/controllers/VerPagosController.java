package controllers;

import dao.PagoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import models.Pago;


public class VerPagosController {

    @FXML private TableView<Pago> tablePagos;
    @FXML private TableColumn<Pago, Integer> colIdPago, colIdReserva;
    @FXML private TableColumn<Pago, Double> colMonto, colTarifa;
    @FXML private TableColumn<Pago, String> colMetodoPago, colFechaPago;

    @FXML
    public void initialize() {
        colIdPago.setCellValueFactory(new PropertyValueFactory<>("idPago"));
        colIdReserva.setCellValueFactory(new PropertyValueFactory<>("idReserva"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        colMetodoPago.setCellValueFactory(new PropertyValueFactory<>("metodoPago"));
        colFechaPago.setCellValueFactory(new PropertyValueFactory<>("fechaPago"));
        colTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifa"));

        ObservableList<Pago> pagos = FXCollections.observableArrayList();
        try {
            pagos.addAll(PagoDAO.obtenerTodos());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablePagos.setItems(pagos);
    }

    @FXML
    public void volverAlMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage) tablePagos.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

