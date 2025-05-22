import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/registrar_vehiculo.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Sistema de Estacionamiento - Registro Vehículo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

