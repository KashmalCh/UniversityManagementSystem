package com.company;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class FE_Affix {
    private Scene scene;
    private Image image;
    private Button button;
    private Hyperlink[] link;
    private ImageView [] linkimageview;
    private Image []linkimage;
    private Image buttonimage;
    private ImageView buttonview ;
    FE_Affix(Stage PrimaryStage)
    {
        try {
            PrimaryStage.setTitle("Affix");
            image = new Image(new FileInputStream("E:\\JavaProject\\Images\\Affix.png"));
            ImageView imageView = new ImageView(image);
            imageView.fitWidthProperty().bind(PrimaryStage.widthProperty());
            imageView.setFitHeight(700);
            linkimage = new Image[3];
            linkimageview = new ImageView[3];


            buttonimage = new Image(new FileInputStream("E:\\JavaProject\\Images\\PowerButton.png"));
            linkimage[0] = new Image(new FileInputStream("E:\\JavaProject\\Images\\MailLogo.png"));
            linkimage[1] = new Image(new FileInputStream("E:\\JavaProject\\Images\\FacebookLogo.png"));
            linkimage[2] = new Image(new FileInputStream("E:\\JavaProject\\Images\\TwitterLogo.png"));


            buttonview = new ImageView(buttonimage);
            linkimageview[0] = new ImageView(linkimage[0]);
            linkimageview[1] = new ImageView(linkimage[1]);
            linkimageview[2] = new ImageView(linkimage[2]);

            buttonview.setFitWidth(40);
            buttonview.setFitHeight(40);


            button = new Button("",buttonview);
            button.setStyle("-fx-background-color: transparent");
            button.setTranslateY(265);
            button.setTranslateX(-180);
            button.setPrefSize(80,50);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1),button);
            fadeTransition.setAutoReverse(true);
            fadeTransition.setFromValue(0.2);
            fadeTransition.setToValue(1.0);
            fadeTransition.setCycleCount(Animation.INDEFINITE);
            fadeTransition.play();

            link = new Hyperlink[3];
            link[0] = new Hyperlink("Info@Affix.pk",linkimageview[0]);
            link[0].setTranslateX(-618);
            link[0].setTranslateY(-330);


            link[1] = new Hyperlink("Affix_MS",linkimageview[1]);
            link[1].setTranslateX(-632);
            link[1].setTranslateY(-292);

            link[2] = new Hyperlink("@AF",linkimageview[2]);
            link[2].setTranslateX(-643);
            link[2].setTranslateY(-255);

            StackPane layout = new StackPane();
            layout.getChildren().addAll(imageView,button);
            layout.getChildren().addAll(link);

            scene = new Scene(layout);
            this.PowerButtonActions(PrimaryStage);
            this.LinksAction();
            PrimaryStage.setScene(scene);

        }
        catch (FileNotFoundException E)
        {
            FE_Dialog.Exception(E);
        }
    }
    private void PowerButtonActions(Stage stage)
    {
        button.setOnMousePressed(e1->
        {
            buttonview.setFitHeight(35);
            buttonview.setFitWidth(35);
        });
        button.setOnMouseReleased(e1->
        {
            buttonview.setFitHeight(40);
            buttonview.setFitWidth(40);
        });
        button.setOnAction(e1->
        {
            Controller.OpenLoginScene(stage);
        });
    }
    private void LinksAction()
    {
        link[0].setOnAction(e->{
            try {
                Desktop.getDesktop().browse(new URL("https://gmail.com").toURI());
            } catch (IOException E)
            {
                FE_Dialog.Exception(E);
            }
            catch (URISyntaxException E)
            {
                FE_Dialog.Exception(E);
            }
        });
        link[1].setOnAction(e->{
            try {
                Desktop.getDesktop().browse(new URL("https://facebook.com").toURI());
            } catch (IOException E)
            {
                FE_Dialog.Exception(E);
            }
            catch (URISyntaxException E)
            {
                FE_Dialog.Exception(E);
            }
        });
        link[2].setOnAction(e->{
            try {
                Desktop.getDesktop().browse(new URL("https://twitter.com").toURI());
            } catch (IOException E)
            {
                FE_Dialog.Exception(E);
            }
            catch (URISyntaxException E)
            {
                FE_Dialog.Exception(E);
            }
        });

    }

}
