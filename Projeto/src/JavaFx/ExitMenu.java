package JavaFx;

import HelperClasses.FileHandler;
import PersonalInfo.Person;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExitMenu extends BorderPane {
    private Stage stage;
    private Person person;
    private Label warning, topLabel;
    private Button btn1;
    private ObservableList<String> items;

    public ExitMenu(Person person) {
        this.person = person;
        getLabels();
        getResults();
        showImage();
    }

    public void getLabels(){
        VBox vBox = new VBox();
        warning = new Label("Please note that these exams don't replace a doctor");
        warning.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
        warning.setAlignment(Pos.CENTER);
        warning.setTextAlignment(TextAlignment.CENTER);
        setAlignment(warning, Pos.CENTER);
        setTop(warning);
        vBox.getChildren().add(warning);
        topLabel = new Label("This is the last page of you check-up \n Here you have all the results");
        topLabel.setFont(Font.font("Verdana", FontWeight.THIN, 20));
        topLabel.setAlignment(Pos.CENTER);
        topLabel.setTextAlignment(TextAlignment.CENTER);
        setAlignment(topLabel, Pos.CENTER);
        setTop(topLabel);
        vBox.getChildren().add(topLabel);
        setAlignment(vBox, Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25);
        vBox.setPadding(new Insets(20));
        setTop(vBox);
    }

    public void showWindow(){
        stage = new Stage();
        stage.setScene(null);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.setTitle("Blood Pressure Test");
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(this, 1100, 1000);
        stage.setScene(scene);

        stage.show();
    }

    public void getResults(){
        Label label = new Label("TESTES FEITOS:");
        ListView<String> tests = new ListView<>();
        items = FXCollections.observableArrayList();
        tests.setItems(items);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, tests);
        setBottom(vbox);
        items.add(person.getClinicalData().printClinicalData());
    }

    public void showImage(){
        VBox vBox = new VBox();
        FileInputStream input = null;
        try {
            input = new FileInputStream("Images/finish.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(input);
        ImageView imageView1 = new ImageView(image1);
        setAlignment(vBox, Pos.CENTER);
        btn1 = new Button("Exit");
        btn1.setAlignment(Pos.CENTER);
        btn1.setOnAction(e -> {
            FileHandler.save(person);
            Platform.exit();
        });
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(imageView1, btn1);
        vBox.setSpacing(20);
        setCenter(vBox);
    }
}
