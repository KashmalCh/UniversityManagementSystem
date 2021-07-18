package com.company;

import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FE_LoginPage {
    private Button button;
    private Separator separator[];
    private Scene scene;
    private Image image;
    private ImageView imageView;
    private TextField field;
    private PasswordField passwordField;

    FE_LoginPage(Stage stage)
    {
        try {
            stage.setTitle("Login");
            image = new Image(new FileInputStream("E:\\JavaProject\\Images\\Login.png"));
            ImageView imageView = new ImageView(image);
            imageView.setSmooth(true);
            imageView.fitWidthProperty().bind(stage.widthProperty());
            imageView.setFitHeight(700);

            button = new Button("Login");
            button.setPrefSize(200,30);
            button.setTranslateX(350);
            button.setTranslateY(185);
            button.getStylesheets().add(getClass().getResource("LoginButton.css").toExternalForm());

            separator = new Separator[2];
            separator[0] = new Separator();
            separator[1] = new Separator();
            field =  new TextField();
            passwordField = new PasswordField();


            separator[0].getStylesheets().add(getClass().getResource("LoginSeparator.css").toExternalForm());
            separator[1].getStylesheets().add(getClass().getResource("LoginSeparator.css").toExternalForm());
            field.getStylesheets().add(getClass().getResource("LoginField.css").toExternalForm());
            passwordField.getStylesheets().add(getClass().getResource("LoginPassword.css").toExternalForm());
            field.setPromptText("Username");
            passwordField.setPromptText("Password");


            VBox UserName = new VBox();
            VBox Password = new VBox();

            final BooleanProperty firstTime = new SimpleBooleanProperty(true);
            final BooleanProperty firstTimeP = new SimpleBooleanProperty(true);
            field.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
                if(newValue && firstTime.get()){
                    UserName.requestFocus(); // Delegate the focus to container
                    firstTime.setValue(false); // Variable value changed for future references
                }
            });
            passwordField.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
                if(newValue && firstTimeP.get()){
                    Password.requestFocus(); // Delegate the focus to container
                    firstTimeP.setValue(false); // Variable value changed for future references
                }
            });

            UserName.setSpacing(0);
            Password.setSpacing(0);
            UserName.getChildren().addAll(field,separator[0]);
            Password.getChildren().addAll(passwordField,separator[1]);
            UserName.setMaxWidth(200);
            Password.setMaxWidth(200);


            double X = 450;
            Line ULine = new Line();
            ULine.setStartX(X);
            ULine.setEndX(450);
            ULine.setStartY(-3000);
            ULine.setEndY(750);
            PathTransition Utransition = new PathTransition();
            Utransition.setPath(ULine);
            Utransition.setDuration(Duration.seconds(0.01));  //...........setback(2)
            Utransition.setCycleCount(1);
            Utransition.setNode(UserName);
            Utransition.play();
            Utransition.setOnFinished(e->
            {
                Line Subline = new Line();
                Subline.setStartX(450);
                Subline.setEndX(450);
                Subline.setStartY(740);
                Subline.setEndY(750);

                PathTransition subtrans = new PathTransition();
                subtrans.setPath(Subline);
                subtrans.setDuration(Duration.seconds(0.05));
                subtrans.setCycleCount(3);
                subtrans.setAutoReverse(true);
                subtrans.setNode(UserName);
                subtrans.play();
            });

            Line PLine = new Line();
            PLine.setStartX(-5000);
            PLine.setEndX(450);
            PLine.setStartY(800);
            PLine.setEndY(800);
            PathTransition Ptransition = new PathTransition();
            Ptransition.setPath(PLine);
            Ptransition.setDuration(Duration.seconds(0.01));  //...........setback(2.9)
            Ptransition.setCycleCount(1);
            Ptransition.setNode(Password);
            Ptransition.play();
            Ptransition.setOnFinished(e->ActionOnButton(stage));
            Ptransition.setOnFinished(e->
            {
                Line Subline = new Line();
                Subline.setStartX(450);
                Subline.setEndX(440);
                Subline.setStartY(800);
                Subline.setEndY(800);

                PathTransition subtrans = new PathTransition();
                subtrans.setPath(Subline);
                subtrans.setDuration(Duration.seconds(0.05));
                subtrans.setCycleCount(4);
                subtrans.setAutoReverse(true);
                subtrans.setNode(Password);
                subtrans.play();
                subtrans.setOnFinished(e1->{
                    ActionOnButton(stage);
                });
            });


            StackPane layout = new StackPane();
            layout.getChildren().addAll(imageView,UserName,Password,button);

            scene = new Scene(layout);
            stage.setScene(scene);
        }
        catch (FileNotFoundException E)
        {
            FE_Dialog.Exception(E);
        }
    }
    private void ActionOnButton(Stage stage)
    {
        button.setOnMouseEntered(e->
        {
            button.setStyle("-fx-background-color: linear-gradient(aquamarine,royalblue)");
        });
        button.setOnMouseExited(e->
        {
            button.setStyle("-fx-background-color: linear-gradient(turquoise,midnightblue)");
        });
        button.setOnMousePressed(e->
        {
            button.setPrefSize(180,20);
            button.setStyle("-fx-font-size: 13 px Comic Sans ; -fx-background-color: linear-gradient(aquamarine,royalblue)");

        });
        button.setOnMouseReleased(e->
        {
            button.setPrefSize(200,30);
            button.setStyle("-fx-font-size: 15 px Comic Sans;-fx-background-color: linear-gradient(aquamarine,royalblue)");
        });
        button.setOnMouseClicked(e->
        {
            String ID = field.getText().toString();
            String Password = passwordField.getText().toString();
            C_Admin admin = new C_Admin(ID,Password);
            String S =Controller.GetAdminPassword(ID);
            if(S==null)
            {
               // FE_Dialog.Information("Not an Admin's Mail" , "Not Found");
                Controller.OpenMainPage(stage);
            }
            else
            {
                if(admin.IsPasswordMatch(S)==true)
                {

                }
                else
                {
                    FE_Dialog.Information("Incorrect Password" , "Not Matched");
                }
            }
        });
    }
}
