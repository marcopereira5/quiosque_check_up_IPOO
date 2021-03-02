package HelperClasses;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JavaFxHelp {
    public static void getScene(String message){
        Stage stage2 = new Stage();
        stage2 = new Stage();
        stage2.setResizable(false);
        stage2.setIconified(false);
        stage2.centerOnScreen();
        stage2.setTitle("Error Message");
        stage2.initModality(Modality.APPLICATION_MODAL);
        Scene scene1 = new Scene(getErrorMessageAux(message), 400, 100);
        stage2.setScene(scene1);
        stage2.show();
    }

    private static BorderPane getErrorMessageAux(String message){
        BorderPane borderPane = new BorderPane();
        Label error = new Label(message);
        error.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Button errorBtn = new Button("OK");
        errorBtn.setOnAction(e -> ((Stage) borderPane.getScene().getWindow()).close());
        borderPane.setTop(error);
        borderPane.setBottom(errorBtn);
        error.setAlignment(Pos.CENTER);
        errorBtn.setAlignment(Pos.CENTER);
        borderPane.setAlignment(error, Pos.CENTER);
        borderPane.setAlignment(errorBtn, Pos.CENTER);
        error.setTextAlignment(TextAlignment.CENTER);
        borderPane.setPadding(new Insets(12, 15, 12, 15));
        return borderPane;
    }
}
