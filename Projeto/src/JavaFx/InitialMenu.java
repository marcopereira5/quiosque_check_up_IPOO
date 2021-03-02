package JavaFx;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InitialMenu extends BorderPane {
    private CreatePerson createPerson;
    private LoadUser load;

    public InitialMenu() {
        Label initialText = mainText();
        setAlignment(initialText, Pos.TOP_CENTER);
        setTop(initialText);
        GridPane box = buttons();
        setAlignment(box, Pos.CENTER);
        setCenter(box);
        HBox exitButton = exitButton();
        setAlignment(exitButton, Pos.CENTER);
        setBottom(exitButton);
    }

    public Label mainText(){
        Label mainText = new Label("Welcome to our check-up clinic!\nPlease select an option:");
        mainText.setTextAlignment(TextAlignment.CENTER);
        mainText.setFont(Font.font("Verdana", FontWeight.THIN, 25));
        mainText.setPadding(new Insets(25, 0, 0, 0));
        return mainText;
    }

    public GridPane buttons(){
        GridPane box = new GridPane();
        FileInputStream input = null;
        FileInputStream input2 = null;
        try {
            input2 = new FileInputStream("Images/yeah.png");
            input = new FileInputStream("Images/yeah2.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);

        Button btn1 = new Button("Create User", imageView);
        box.add(btn1, 0, 0);
        btn1.setOnAction(e -> {
            createPerson = new CreatePerson();
            createPerson.showWindow();

        });

        Button btn2 = new Button("Load User", imageView2);
        box.add(btn2,  1, 0);
        btn2.setOnAction(e -> {
            load = new LoadUser();
            load.showWindow();
        });

        box.setHgap(70);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public HBox exitButton(){
        HBox box = new HBox();
        FileInputStream input = null;
        try {
            input = new FileInputStream("Images/shutdown.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image image3 = new Image(input);
        ImageView imageView3 = new ImageView(image3);

        Button exitButton = new Button("Exit", imageView3);
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setMinWidth(520);
        exitButton.setOnAction(e -> Platform.exit());
        box.getChildren().add(exitButton);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(0, 0, 30, 0));
        return box;
    }
}
