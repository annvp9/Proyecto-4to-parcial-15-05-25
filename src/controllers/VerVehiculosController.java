package controllers;

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

import models.Vehiculo;
import dao.VehiculoDAO;

public class VerVehiculosController {

    @FXML private TableView<Vehiculo> tableVehiculos;
    @FXML private TableColumn<Vehiculo, Integer> colCliente;
    @FXML private TableColumn<Vehiculo, String> colPlaca, colMarca, colModelo, colColor, colTipo;

    @FXML
    public void initialize() {
        colCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        ObservableList<Vehiculo> vehiculos = FXCollections.observableArrayList();
        try {
            vehiculos.addAll(VehiculoDAO.obtenerTodos());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableVehiculos.setItems(vehiculos);
    }

    @FXML
    public void volverAlMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage) tableVehiculos.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
