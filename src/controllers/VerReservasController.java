package controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import dao.ReservaDAO;
import models.Reserva;

public class VerReservasController {

    @FXML
    private TableView<Reserva> tableReservas;
    @FXML
    private TableColumn<Reserva, Integer> colIdReserva, colIdCliente, colIdEspacio;
    @FXML
    private TableColumn<Reserva, String> colFechaInicio, colFechaFin;
    @FXML
    private Button btnMenu;

    @FXML
    public void initialize() {
        colIdReserva.setCellValueFactory(new PropertyValueFactory<>("idReserva"));
        colIdCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        colIdEspacio.setCellValueFactory(new PropertyValueFactory<>("idEspacio"));
        colFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        colFechaFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));

        ObservableList<Reserva> reservas = FXCollections.observableArrayList();
        try {
            reservas.addAll(ReservaDAO.obtenerTodos());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableReservas.setItems(reservas);
    }

    @FXML
    public void volverAlMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

