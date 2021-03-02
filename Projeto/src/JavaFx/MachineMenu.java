package JavaFx;

import MachinesTests.Thermometer;
import MachinesTests.Tonometer;
import PersonalInfo.Person;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MachineMenu extends VBox {
    private Person person;
    private BloodPressureTest bpt;
    private Stage stage;
    private Button audiometer, balance, bloodPressure, horizontalScale, oximeter, thermometer,
            tonometer, visualMonitor, exit;

    public MachineMenu(Person person) {
        this.person = person;
        setSpacing(20);
        getLabel();
        getButtons();
    }

    public void getButtons(){
        audiometer = new Button("Audiometer Test");
        audiometer.setOnAction(e ->{
            AudiometerFx audiometerFx = new AudiometerFx(person);
        });
        balance = new Button("Balance");
        balance.setOnAction(e -> {
            BalanceFx balanceFx = new BalanceFx(person);
            balanceFx.ShowWindow();
        });
        bloodPressure = new Button("Blood Pressure Test");
        bloodPressure.setOnAction(e -> {
            bpt = new BloodPressureTest(person);
            bpt.showWindow();
        });
        horizontalScale = new Button("Horizontal Scale Test");
        horizontalScale.setOnAction(e -> {
            HorizontalScaleFx horizontalScaleFx = new HorizontalScaleFx(person);
            horizontalScaleFx.ShowWindow();
        });
        oximeter = new Button("Oximeter Test");
        oximeter.setOnAction(e -> {
            OximeterFx oximeterFx = new OximeterFx(person);
            oximeterFx.ShowWindow();
        });
        thermometer = new Button("Temperature Test");
        thermometer.setOnAction(e -> {
            ThermometerFx thermometerFx = new ThermometerFx(person);
            thermometerFx.ShowWindow();
        });
        tonometer = new Button("Tonometer Test");
        tonometer.setOnAction(e -> {
            TonometerFx tonometer = new TonometerFx(person);
            tonometer.ShowWindow();
        });
        visualMonitor = new Button("Visual Monitor Test");
        visualMonitor.setOnAction(e -> {
            VisualMonitorFx visualMonitorFx = new VisualMonitorFx(person);
            visualMonitorFx.ShowWindow();
        });
        exit = new Button("Exit");
        exit.setOnAction(e -> {
            ExitMenu menu = new ExitMenu(person);
            menu.showWindow();
            stage.close();
        });
        getChildren().addAll(audiometer, balance, bloodPressure, horizontalScale, oximeter, thermometer, tonometer, visualMonitor, exit);
    }

    public void getLabel(){
        Label label = new Label("Choose the test you want to do:");
        setAlignment(Pos.CENTER);
        label.setFont(Font.font("Verdana", FontWeight.THIN, 17));
        label.setTextAlignment(TextAlignment.CENTER);
        label.setAlignment(Pos.CENTER);
        getChildren().add(label);
    }

    public void showWindow(){
        stage = new Stage();
        stage.setScene(null);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.setTitle("Main Menu");
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(this, 400, 500);
        stage.setScene(scene);

        stage.show();
    }

}
