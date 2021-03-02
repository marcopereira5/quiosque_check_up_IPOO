package JavaFx;

import MachinesTests.HorizontalScale;
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

public class HorizontalScaleFx extends BorderPane {

    private HorizontalScale horizontalScale;
    private Person person;
    private ListView<String> listView;
    private Stage stage;

    public HorizontalScaleFx(Person person){
        this.person = person;
        horizontalScale = new HorizontalScale(person);
        initializeItems();
        addPerformTestButton();
    }

    private ObservableList<String> initializeItems(){
        Label label = new Label("TESTES FEITOS:");
        listView = new ListView<>();
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
        stage.setTitle("Horizontal Scale");

        Scene scene = new Scene(this, 600, 600);
        stage.setScene(scene);

        stage.show();
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
            horizontalScale = new HorizontalScale(person);
            horizontalScale.runTests();
            person.addTest(horizontalScale);
            items.add(horizontalScale.getInfo());});

        this.setCenter(btn);
    }
}