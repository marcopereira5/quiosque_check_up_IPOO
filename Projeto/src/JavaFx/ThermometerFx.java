package JavaFx;

import MachinesTests.Thermometer;
import PersonalInfo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThermometerFx extends BorderPane {

    private Stage stage;
    private Thermometer thermometer;
    private Person person;
    private ListView<String> listView;

    public ThermometerFx (Person person){
        thermometer = new Thermometer(person);
        this.person = person;
        initializeItems();
        addPerformTestButton();
    }

    private void addPerformTestButton() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("Images/Perform.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(input);
        ImageView imageView1 = new ImageView(image1);
        Button btn = new Button("Perform Test", imageView1);

        ObservableList<String> items = initializeItems();

        btn.setOnAction(event -> {
            thermometer = new Thermometer(person);
            thermometer.runTests();
            person.addTest(thermometer);
            items.add(thermometer.getInfo());});

        this.setCenter(btn);

    }

    private ObservableList<String> initializeItems(){
        listView = new ListView<>();
        Label label = new Label("TESTES FEITOS:");
        ObservableList<String> items = FXCollections.observableArrayList();
        listView.setItems(items);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, listView);
        this.setBottom(vbox);
        return  items;
    }
    public void ShowWindow(){
        stage = new Stage();
        stage.setScene(null);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Thermometer");

        Scene scene = new Scene(this, 850, 950);
        stage.setScene(scene);

        stage.show();
    }
}