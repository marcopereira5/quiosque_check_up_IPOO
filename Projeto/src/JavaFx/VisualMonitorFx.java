package JavaFx;

import MachinesTests.Tonometer;
import MachinesTests.VisualMonitor;
import PersonalInfo.Person;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VisualMonitorFx extends BorderPane {

    private Person person;
    private Stage stage;
    private Tonometer tonometer;
    private ListView<String> listView;
    private VisualMonitor visualMonitor;

    public VisualMonitorFx(Person person){
        this.person = person;
        visualMonitor = new VisualMonitor(person);
        listView = new ListView<>();
        addPerformTestButton();
        addImages();
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
            visualMonitor.runTests();
            person.addTest(visualMonitor);
            items.add(visualMonitor.getInfo());});

        btn.setAlignment(Pos.CENTER);
        setAlignment(btn, Pos.CENTER);
        this.setTop(btn);


    }

    private ObservableList<String> initializeItems(){
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

    private void addImages(){
        FileInputStream input = null;
        FileInputStream input2 = null;
        FileInputStream input3 = null;
        try {
            input = new FileInputStream("Images/colorBlindness.jpg");
            input3 = new FileInputStream("Images/Astigmatism.jpg");
            input2 = new FileInputStream("Images/visualAcuity.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        this.setCenter(imageView);

        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);

        Image image3 = new Image(input3);
        ImageView imageView3 = new ImageView(image3);

        this.setRight(imageView2);
        this.setLeft(imageView3);
        this.setCenter(imageView);

    }

    public void ShowWindow(){
        stage = new Stage();
        stage.setScene(null);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Tonometer");

        Scene scene = new Scene(this, 850, 950);
        stage.setScene(scene);

        stage.show();
    }
}