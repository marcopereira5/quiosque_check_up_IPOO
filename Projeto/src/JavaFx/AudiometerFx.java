package JavaFx;

import MachinesTests.Audiometer;
import PersonalInfo.Person;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class AudiometerFx {
    private Person person;

    public AudiometerFx(Person person) {
        this.person = person;
        createScene();
    }

    public void createScene(){
        FileInputStream input = null;
        try {
            input = new FileInputStream("Images/Perform.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Frequência: ");
        yAxis.setLabel("Décibeis de Volume: ");
        final NumberAxis xAxis1 = new NumberAxis();
        final NumberAxis yAxis1 = new NumberAxis();
        xAxis1.setLabel("Frequência: ");
        yAxis1.setLabel("Décibeis de Volume: ");
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series1 = new XYChart.Series();
        series.setName("Left Ear");
        series1.setName("Right Ear");

        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("Left Ear");
        lineChart.setAnimated(false);
        final LineChart<Number,Number> lineChart1 =
                new LineChart<Number,Number>(xAxis1,yAxis1);
        lineChart1.setTitle("Right Ear");
        lineChart1.setAnimated(false);

        Image image1 = new Image(input);
        ImageView imageView1 = new ImageView(image1);
        Button btn = new Button("Perform Test",imageView1);
        btn.setOnAction(event -> {
            Audiometer a = new MachinesTests.Audiometer(person);
            person.addTest(a);
            if(!lineChart.getData().isEmpty() || !lineChart1.getData().isEmpty()){
                series.getData().clear();
                series1.getData().clear();
            }
            Map map = a.getResults();
            Map map1 = a.getResults();
            for(Object in: map.keySet()){
                series.getData().add(new XYChart.Data(in,map.get(in)));
            }
            for(Object in: map1.keySet()){
                series1.getData().add(new XYChart.Data(in,map1.get(in)));
            }

            lineChart.getData().clear();
            lineChart1.getData().clear();
            lineChart.getData().add(series);
            lineChart1.getData().add(series1);
        });

        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        BorderPane root = new BorderPane();
        root.setLeft(lineChart);
        root.setRight(lineChart1);
        root.setCenter(btn);
        Scene scene = new Scene(root, 1555, 1000);
        primaryStage.setTitle("Audimeter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
