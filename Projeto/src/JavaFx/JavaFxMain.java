package JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class JavaFxMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new InitialMenu();
        Scene scene = new Scene(root, 720, 500);
        primaryStage.setTitle("Initial Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

