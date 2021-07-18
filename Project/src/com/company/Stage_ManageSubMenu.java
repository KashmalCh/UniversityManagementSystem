package com.company;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public abstract class Stage_ManageSubMenu {
    protected Stage stage;
    protected Scene scene;
    protected Button done;
    protected Button cancel;
    protected TextField field;
    protected ImageView doneview;
    protected ImageView cancelview;
    protected ImageView background;
    protected StackPane pane;
    protected VBox input;
    protected Separator separator;

    Stage_ManageSubMenu(){};
    Stage_ManageSubMenu(String Prompt)
    {
        try {
            stage = new Stage();
            stage.setHeight(300);
            stage.setWidth(600);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);

            background = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Stage.png")));
            background.setStyle("-fx-background-color: transparent");
            background.setFitHeight(300);
            background.setFitWidth(600);

            pane = new StackPane();
            pane.setStyle("-fx-background-color: transparent");



            input = new VBox();
            input.setStyle("-fx-background-color: transparent");
            input.setPrefWidth(200);
            input.setPrefHeight(100);

            field = new TextField();
            field.setPrefWidth(450);
            field.setPrefHeight(30);
            field.setPromptText(Prompt);
            field.setStyle("-fx-background-color: transparent; -fx-font-size: 15px times; -fx-font-family: 'times';" +
                    "-fx-text-fill: gainsboro");
            final BooleanProperty firstTime = new SimpleBooleanProperty(true);
            field.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
                if(newValue && firstTime.get()){
                    input.requestFocus(); // Delegate the focus to container
                    firstTime.setValue(false); // Variable value changed for future references
                }
            });


            separator = new Separator();
            separator.setStyle(" -fx-border-style: solid;\n" +
                    "    -fx-background-color: Gray;\n" +
                    "    -fx-fill: Gray;\n" +
                    "    -fx-text-fill: Gray;\n" +
                    "    -fx-border-width: 0.5px;\n" +
                    "    -fx-border-color: Gray;");
            separator.setPrefWidth(450);

            input.getChildren().addAll(field,separator);

            done = new Button();
            done.setPrefWidth(30);
            done.setPrefHeight(30);
            doneview = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\TickStage.png")));
            doneview.setFitWidth(35);
            doneview.setFitHeight(35);
            done.setGraphic(doneview);
            done.setStyle("-fx-background-color: transparent; -fx-background-radius: 5");
            done.setTranslateY(23);
            done.setTranslateX(130);

            cancel = new Button();
            cancelview = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\CrossStage.png")));
            cancelview.setFitWidth(30);
            cancelview.setFitHeight(30);
            cancel.setPrefHeight(25);
            cancel.setPrefWidth(25);
            cancel.setGraphic(cancelview);
            cancel.setStyle("-fx-background-color: transparent; -fx-background-radius: 5");
            cancel.setTranslateY(23);
            cancel.setTranslateX(170);
            this.SetOnAction();


            input.setPadding(new Insets(0,370,0,0));
            input.setTranslateX(100);
            input.setTranslateY(150);

            pane.getChildren().addAll(background,input,done,cancel);

            scene = new Scene(pane);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.centerOnScreen();
            Controller.OnCenterofScreen(stage);
            this.SetOnAction();
            stage.show();
        }
        catch (FileNotFoundException E)
        {
            FE_Dialog.Exception(E);
        }

    }
    protected void SetOnAction()
    {

        done.setOnMouseEntered(e->
        {
            done.setEffect(new Glow(0.5));
        });
        done.setOnMouseExited(e->
        {
            done.setEffect(new Glow(0));
        });
        cancel.setOnMouseEntered(e->
        {
            cancel.setEffect(new Glow(0.51));
        });
        cancel.setOnMouseExited(e->
        {
            cancel.setEffect(new Glow(0));
        });
        done.setOnMousePressed(e->
        {
            doneview.setFitWidth(30);
            doneview.setFitHeight(30);
        });
        done.setOnMouseReleased(e->
        {
            doneview.setFitWidth(35);
            doneview.setFitHeight(35);
        });

        cancel.setOnMousePressed(e->
        {
            cancelview.setFitHeight(25);
            cancelview.setFitWidth(25);
        });
        cancel.setOnMouseReleased(e->
        {
            cancelview.setFitHeight(30);
            cancelview.setFitWidth(30);
        });
        cancel.setOnAction(e->
        {
            stage.close();
        });
    }
}
