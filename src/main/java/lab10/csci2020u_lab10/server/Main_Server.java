package lab10.csci2020u_lab10.server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main_Server extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("server.fxml"));
        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();

        // FXMLLoader fxmlLoader = new FXMLLoader(Main_Server.class.getResource("server.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        // primaryStage.setTitle("Server");
        // primaryStage.setScene(scene);
        // primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
