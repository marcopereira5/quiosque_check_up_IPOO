package JavaFx;

import HelperClasses.FileHandler;
import PersonalInfo.Person;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoadUser extends BorderPane {
    private Person person;
    private Stage stage, stage2;
    private Label label1;
    private Label label;
    private TextField textField;
    private Button btn1, btn2;
    private MachineMenu machineMenu;

    public LoadUser() {
        label1 = new Label("Please enter your name \nfor profile selection");
        label1.setFont(Font.font("Verdana", FontWeight.THIN, 17));
        label1.setTextAlignment(TextAlignment.CENTER);
        label1.setAlignment(Pos.CENTER);
        setAlignment(label1, Pos.CENTER);
        setTop(label1);
        HBox textField = getTextField();
        HBox buttons = getButton();
        textField.setAlignment(Pos.CENTER);
        setAlignment(textField, Pos.CENTER);
        setCenter(textField);
        setBottom(buttons);
    }

    public HBox getTextField(){
        HBox box = new HBox();
        label = new Label("Name: ");
        textField = new TextField();

        box.getChildren().addAll(label, textField);
        return box;
    }

    public HBox getButton(){
        HBox box = new HBox();
        box.setPadding(new Insets(12, 15, 12, 15));
        box.setSpacing(15);
        btn1 = new Button("Submit");
        btn1.setOnAction(e -> getPerson());
        btn2 = new Button("Exit");
        btn2.setOnAction(e -> stage.close());
        box.getChildren().addAll(btn1, btn2);
        return box;
    }

    public void showWindow(){
        stage = new Stage();
        stage.setScene(null);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(this, 400, 150);
        stage.setScene(scene);

        stage.show();
    }

    public void getPerson(){
        String name = textField.getText();
        person = FileHandler.load(name);

        if (person.getName().equalsIgnoreCase("invalid")) {
            stage.close();
            stage2 = new Stage();
            stage2.setResizable(false);
            stage2.setIconified(false);
            stage2.centerOnScreen();
            stage2.initModality(Modality.APPLICATION_MODAL);
            Scene scene1 = new Scene(getErrorMessage(), 400, 100);
            stage2.setScene(scene1);
            stage2.show();
        } else {
            stage.close();
            machineMenu = new MachineMenu(person);
            machineMenu.showWindow();
        }
    }

    public BorderPane getErrorMessage(){
        BorderPane borderPane = new BorderPane();
        Label error = new Label("The profile you \ninputed is not valid");
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

    public Person getPersonAux(){
        return person;
    }

    public boolean isStageShowing(){
        return stage.isShowing();
    }
}
