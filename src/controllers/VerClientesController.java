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

import models.Cliente;
import dao.ClienteDAO;

public class VerClientesController {

    @FXML private TableView<Cliente> tableClientes;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colApellido;
    @FXML private TableColumn<Cliente, String> colCorreo;
    @FXML private TableColumn<Cliente, String> colTelefono;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        cargarClientes();
    }

    @FXML
    public void cargarClientes() {
        try {
            ObservableList<Cliente> clientes = FXCollections.observableArrayList(ClienteDAO.obtenerTodos());
            tableClientes.setItems(clientes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void volverAlMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/main_menu.fxml"));
            Stage stage = (Stage) tableClientes.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}