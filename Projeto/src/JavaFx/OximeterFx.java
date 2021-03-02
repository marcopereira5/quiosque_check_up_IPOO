package JavaFx;

import MachinesTests.Oximeter;
import PersonalInfo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class OximeterFx extends BorderPane {
    private Person person;
    private ObservableList<String> items;
    private final NumberAxis xAxis = new NumberAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
    private XYChart.Series series;
    private Stage stage;

    public OximeterFx(Person person) {
        this.person = person;
        getList();
        getGraphic();
        getImages();
    }

    public void getImages(){
        FileInputStream input = null;
        try {
            input = new FileInputStream("Images/Perform.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(input);
        ImageView imageView1 = new ImageView(image1);
        Button btn = new Button("Perform Test",imageView1);
        btn.setAlignment(Pos.CENTER);
        setAlignment(btn, Pos.CENTER);
        btn.setOnAction(event -> {
            Oximeter oximeter = new Oximeter(person);
            if(!lineChart.getData().isEmpty()){
                series.getData().clear();
            }
            oximeter.runTests();
            Map map = oximeter.getResults();
            System.out.println("Oh yeah");
            for (Object in : map.keySet()){
                series.getData().add(new XYChart.Data<>(in,map.get(in)));
            }

            lineChart.getData().clear();
            lineChart.getData().add(series);
            person.addTest(oximeter);
            items.add(oximeter.getInfo());
        });
        btn.setAlignment(Pos.CENTER);
        setAlignment(btn, Pos.CENTER);
        setTop(btn);
    }

    public void getGraphic(){
        xAxis.setLabel("Tempo: ");
        yAxis.setLabel("Nivel: ");
        lineChart.setTitle("Heart Rate");
        lineChart.setAnimated(false);
        series = new XYChart.Series();
        series.setName("HearthRate Graph");
        setBottom(lineChart);
    }

    public void getList(){
        ListView<String> tests = new ListView<>();
        items = FXCollections.observableArrayList();
        tests.setItems(items);
        setCenter(tests);
    }

    public void ShowWindow(){
        stage = new Stage();
        stage.setScene(null);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Thermometer");

        Scene scene = new Scene(this, 1600, 1000);
        stage.setScene(scene);

        stage.show();
    }
}
