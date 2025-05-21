package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import utils.ConexionDB;
import utils.HashUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;

    @FXML
    public void iniciarSesion() {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        try (Connection conn = ConexionDB.getConexion()) {
            String sql = "SELECT * FROM empleados WHERE correo_electronico = ? AND password_sha1 = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, HashUtil.sha1(password));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                lblMensaje.setText("Login exitoso. Bienvenido " + rs.getString("nombre"));

            } else {
                lblMensaje.setText("Usuario o contraseña incorrectos");
            }
        } catch (Exception e) {
            lblMensaje.setText("Error al iniciar sesión: " + e.getMessage());
        }
    }
}
