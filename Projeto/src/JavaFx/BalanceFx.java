package JavaFx;

import HelperClasses.JavaFxHelp;
import MachinesTests.Balance;
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

public class BalanceFx extends BorderPane {

    private Stage stage;
    private Person person;
    private Balance balance;
    private ListView<String> listView;
    private ObservableList<String> items;

    public BalanceFx (Person person){
        this.person = person;
        listView = new ListView<>();
        addPerformTestButton();
        addImagemIMC();
    }

    private void addImagemIMC(){
        FileInputStream input = null;
        try {
            input = new FileInputStream("Images/IMC2.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        this.setCenter(imageView);
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
        btn.setAlignment(Pos.CENTER);
        setAlignment(btn, Pos.CENTER);

        items = initializeItems();

        btn.setOnAction(event -> doTest());

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

    public void ShowWindow(){
        stage = new Stage();
        stage.setScene(null);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.centerOnScreen();
        stage.setTitle("Balance");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Balance and Stadiometer");

        Scene scene = new Scene(this, 600, 800);
        stage.setScene(scene);

        stage.show();
    }

    public void doTest(){
        Balance bpg = new Balance(person);

        if (!bpg.moved()){
            person.addTest(bpg);
            bpg.runTests();
            items.add(bpg.getInfo());
        } else {
            JavaFxHelp.getScene("You moved please repeat the test!");
        }
    }

}