

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Sistema Estacionamiento - Login");
        stage.setScene(scene);
        stage.show();
    }
}

