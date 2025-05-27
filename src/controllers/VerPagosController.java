package controllers;

import dao.PagoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import models.Pago;

import java.io.IOException;
import java.math.BigDecimal;

public class VerPagosController {

    @FXML
    private TableView<Pago> tablePagos;

    @FXML
    private TableColumn<Pago, Integer> colIdReserva;

    @FXML
    private TableColumn<Pago, BigDecimal> colMonto;

    @FXML
    private TableColumn<Pago, String> colMetodoPago;

    @FXML
    private TableColumn<Pago, String> colFechaPago;

    @FXML
    public void initialize() {
        colIdReserva.setCellValueFactory(new PropertyValueFactory<>("idReserva"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        colMetodoPago.setCellValueFactory(new PropertyValueFactory<>("metodoPago"));
        colFechaPago.setCellValueFactory(cellData ->
                javafx.beans.binding.Bindings.createStringBinding(() ->
                        cellData.getValue().getFechaPago().toLocalDate().toString())
        );

        ObservableList<Pago> lista = FXCollections.observableArrayList(PagoDAO.obtenerPagos());
        tablePagos.setItems(lista);
    }

    @FXML
    public void volverAlMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
