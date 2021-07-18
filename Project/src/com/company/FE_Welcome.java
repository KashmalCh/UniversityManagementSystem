package com.company;

import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FE_Welcome {
    private Image image;
    private Button button;
    private Scene scene;
    private  Image buttonimage;
    private ImageView buttonview;

    FE_Welcome(Stage stage)
    {
        try {
            boolean check = true;
            stage.setTitle("Welcome");
            image = new Image(new FileInputStream("E:\\JavaProject\\Images\\Welcome.png"));
            ImageView imageView = new ImageView(image);
            imageView.setSmooth(true);
            imageView.fitWidthProperty().bind(stage.widthProperty());
            imageView.setFitHeight(700);



            buttonimage = new Image(new FileInputStream("E:\\JavaProject\\Images\\WelButton.png"));
            buttonview = new ImageView(buttonimage);
            buttonview.setFitWidth(400);
            buttonview.setFitHeight(320);
            buttonview.setPreserveRatio(true);


            Line line = new Line();
            line.setStartX(-50000);
            line.setStartY(-170);
            line.setEndX(560);
            line.setEndY(-170);
            button = new Button("",buttonview);
            button.setStyle("-fx-background-color: transparent");
            PathTransition transition = new PathTransition();
            transition.setNode(button);
            transition.setDuration(Duration.seconds(0.01)); //.................SetBack(2.5)
            transition.setPath(line);
            transition.setCycleCount(1);
            transition.play();
            transition.setOnFinished(e->
            {
               WelcomeButtonActions(stage);
            });

            StackPane layout = new StackPane();
            layout.getChildren().addAll(imageView,button);


            scene = new Scene(layout);

            stage.setScene(scene);
        }
        catch (FileNotFoundException E)
        {
            FE_Dialog.Exception(E);
        }

    }
    private void WelcomeButtonActions(Stage stage)
    {
        button.setOnMouseEntered(e1->
        {
            buttonview.setFitHeight(370);
            buttonview.setFitWidth(450);
        });
        button.setOnMouseExited(e1->
        {
            buttonview.setFitHeight(320);
            buttonview.setFitWidth(400);
        });
        button.setOnMousePressed(e1->
        {
            button.setOpacity(0.7);
        });
        button.setOnMouseReleased(e1->
        {
            button.setOpacity(1);

        });
        button.setOnAction(
                e1-> {
                    Controller.OpenAffixScene(stage);
         });

    }
}

