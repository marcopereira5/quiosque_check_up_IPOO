package JavaFx;

import PersonalInfo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreatePerson extends BorderPane {
    private Label topLabel;
    private MachineMenu machineMenu;
    private Stage stage;
    private TextField nameField;
    private DatePicker picker;
    Button btn1, btn2;
    ComboBox<Character> genders;
    private Person person;

    public CreatePerson() {
        topLabel = new Label("Please enter your information");
        topLabel.setPadding(new Insets(20, 0, 0, 0));
        topLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        topLabel.setAlignment(Pos.CENTER);
        setAlignment(topLabel, Pos.CENTER);
        topLabel.setTextAlignment(TextAlignment.CENTER);
        setTop(topLabel);

        setCenter(getTextFields());
        setBottom(createButtons());
    }

    public GridPane getTextFields(){
        GridPane pane = new GridPane();
        Label name = new Label("Name: ");
        nameField = new TextField();
        Label date = new Label("Date of Birth: ");
        picker = new DatePicker();
        Label gender = new Label("Gender: ");
        genders = new ComboBox<>();
        ObservableList<Character> items = FXCollections.observableArrayList();
        genders.setItems(items);
        items.addAll('M', 'F');

        pane.add(name, 0, 0);
        pane.add(nameField, 1, 0);
        pane.add(date, 0, 1);
        pane.add(picker, 1, 1);
        pane.add(gender, 0, 2);
        pane.add(genders, 1, 2);

        pane.setVgap(20);
        pane.setHgap(15);
        pane.setPadding(new Insets(30, 15, 12, 15));
        return pane;
    }

    public HBox createButtons(){
        HBox box = new HBox();
        btn1 = new Button("Submit");
        btn2 = new Button("Exit");
        btn1.setOnAction(e -> getPerson());
        btn2.setOnAction(e -> stage.close());
        box.getChildren().addAll(btn1, btn2);
        box.setSpacing(20);
        box.setPadding(new Insets(12, 15, 12,15));
        return box;
    }

    public void showWindow(){
        stage = new Stage();
        stage.setScene(null);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(this, 400, 270);
        stage.setScene(scene);

        stage.show();
    }

    public void getPerson(){
        person = null;
        try {
            person = new Person(nameField.getText(), picker.getValue().toString(), genders.getSelectionModel().getSelectedItem());
        } catch (IllegalArgumentException | NullPointerException e){
            nameField.setText("");
            picker.getEditor().clear();
            genders.getSelectionModel().clearSelection();
            Label label3 = new Label("The information you choose is incorrect");
            label3.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
            label3.setPadding(new Insets(20, 0, 0, 0));
            label3.setAlignment(Pos.CENTER);
            setAlignment(label3, Pos.CENTER);
            setTop(label3);
        }

        if (nameField.getText().equalsIgnoreCase("")){
            person = null;
        } else {
            stage.close();
            machineMenu = new MachineMenu(person);
            machineMenu.showWindow();
        }
    }

    public Person getPersonAux(){
        return person;
    }
}
