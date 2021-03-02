package JavaFx;

import HelperClasses.JavaFxHelp;
import HelperClasses.TimeAux;
import MachinesTests.BloodPressureGauger;
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

public class BloodPressureTest extends BorderPane {
    private Person person;
    private Button btn;
    private Label label;
    private Stage stage;
    private ObservableList<String> items;

    public BloodPressureTest(Person person) {
        this.person = person;
        getImages();
        getResults();
    }

    public void getImages(){
        FileInputStream input1 = null;
        FileInputStream input2 = null;
        try {
            input2 = new FileInputStream("Images/blood.jpg");
            input1 = new FileInputStream("Images/Perform.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(300);
        imageView2.setFitWidth(500);
        Image image1 = new Image(input1);
        ImageView imageView1 = new ImageView(image1);
        setAlignment(imageView2, Pos.CENTER);
        btn = new Button("Perform Test",imageView1);
        btn.setOnAction(e -> {
            doTest();
        });
        Button btn2 = new Button("Exit");
        btn.setAlignment(Pos.CENTER);
        setAlignment(btn,Pos.CENTER);
        setCenter(btn);
        setTop(imageView2);
    }

    public void getResults(){
        label = new Label("TESTES FEITOS:");
        ListView<String> tests = new ListView<>();
        items = FXCollections.observableArrayList();
        tests.setItems(items);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, tests);
        setBottom(vbox);
    }

    public void showWindow(){
        stage = new Stage();
        stage.setScene(null);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.setTitle("Blood Pressure Test");
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(this, 1100, 900);
        stage.setScene(scene);

        stage.show();
    }

    public void doTest(){
        BloodPressureGauger bpg = new BloodPressureGauger(person);

        if (!bpg.moved()){
            bpg.runTests();
            person.addTest(bpg);
            items.add(bpg.getInfo());
        } else {
            JavaFxHelp.getScene("You moved please repeat the test!");
        }
    }
}
