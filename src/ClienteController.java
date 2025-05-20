package controller;

import dao.ClienteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Models.Cliente;

public class ClienteController {
    @FXML private TextField txtNombre, txtApellido, txtCorreo, txtTelefono, txtDireccion;
    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn<Cliente, Integer> colId;
    @FXML private TableColumn<Cliente, String> colNombre, colApellido, colCorreo;

    private ClienteDAO clienteDAO = new ClienteDAO();
    private ObservableList<Cliente> listaClientes;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getId()).asObject());
        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colApellido.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getApellido()));
        colCorreo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCorreo()));
        cargarClientes();
    }

    public void registrar() {
        Cliente nuevo = new Cliente(0,
                txtNombre.getText(),
                txtApellido.getText(),
                txtCorreo.getText(),
                txtTelefono.getText(),
                txtDireccion.getText()
        );
        clienteDAO.registrarCliente(nuevo);
        limpiarCampos();
        cargarClientes();
    }

    private void cargarClientes() {
        listaClientes = FXCollections.observableArrayList(clienteDAO.obtenerTodos());
        tablaClientes.setItems(listaClientes);
    }

    private void limpiarCampos() {
        txtNombre.clear(); txtApellido.clear(); txtCorreo.clear();
        txtTelefono.clear(); txtDireccion.clear();
    }
}
