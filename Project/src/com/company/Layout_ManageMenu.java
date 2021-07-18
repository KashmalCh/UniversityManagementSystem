package com.company;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class Layout_ManageMenu extends Layout_Home {

    protected Label[] labels;
    HBox []iconcover;

    Layout_ManageMenu()
    {
        labels = null;
    }
    protected void LoadImages()
    {
    }
    protected void Main(BorderPane pane,String description) {
        cpane = new StackPane();
        cpane.setStyle("-fx-background-color: white");
        pane.setCenter(cpane);
        cpane.setPadding(new Insets(100,150,100,150));

        iconcover = new HBox[totalicons];
        icons = new Button[totalicons];
        labels = new Label[totalicons];
        HandleIcons(description);

        cpane.getChildren().add(gridPane);
        pane.setCenter(cpane);

        this.SetOnAction();

    }
    protected void HandleIcons(String descrition)
    {
        String []actions = {"Add ","Delete ","Edit ","About "};
        for(int i=0; i<totalicons; i++) {
            icons[i] = new Button("",iconsimage[i]);
            icons[i].setPrefSize(200,160);
            icons[i].setStyle("-fx-background-color: #f2f2f2; -fx-background-radius: 10");
            iconsimage[i].setFitHeight(50);
            iconsimage[i].setFitWidth(50);
            iconcover[i] = new HBox();
            iconcover[i].setPrefSize(200,160);
            iconcover[i].getChildren().add(icons[i]);
            icons[i].setAlignment(Pos.CENTER);
            iconcover[i].setAlignment(Pos.CENTER);
            labels[i] = new Label(actions[i]+descrition);
            labels[i].setPrefSize(200,50);
            labels[i].setOpacity(0);
            labels[i].setStyle("-fx-background-color: transparent; -fx-text-fill: linear-gradient(Indigo,Teal,Black)" +
                    "; -fx-font-size: 25px Times; -fx-font-family: 'Tw Cen MT'; -fx-underline: true");

        }

        gridPane = new GridPane();
        for(int j=0; j<4; j++) {
            GridPane.setConstraints(iconcover[j],j,j);
            if(j!=3){
                labels[j].setAlignment(Pos.CENTER);
                labels[j].setPadding(new Insets(0,0,0,0));
                GridPane.setConstraints(labels[j],j+1,j);}
            else{
                labels[j].setAlignment(Pos.CENTER);
                labels[j].setPadding(new Insets(0,0,0,0));
                GridPane.setConstraints(labels[j],j-1,j);}
        }
        gridPane.getChildren().addAll(iconcover);
        gridPane.getChildren().addAll(labels);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #d8d8d8");
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(60,0,50,0));
    }
    protected void SetOnAction()
    {
        for(int i=0; i<totalicons; i++)
        {
            Button temp = icons[i];
            Label  templabel = labels[i];
            ImageView tempview = iconsimage[i];
            temp.setOnMouseEntered(e->
            {
                temp.setEffect(new InnerShadow(20, Color.TEAL));

                Effect effect1 = new InnerShadow(20,Color.DARKSLATEGRAY);
                Effect effect2 = new Glow(0.4);
                Transition(templabel);
                ((InnerShadow) effect1).setInput(effect2);
                temp.setEffect(effect1);

            });
            temp.setOnMouseExited(e->
            {
                temp.setEffect(new InnerShadow(0, Color.TEAL));
                Effect effect1 = new InnerShadow(0,Color.GRAY);
                Effect effect2 = new Glow(0);
                EndTransition(templabel);
                ((InnerShadow) effect1).setInput(effect2);
                temp.setEffect(effect1);

            });
            temp.setOnMousePressed(e->
            {
                temp.setStyle("-fx-background-color: #f2f2f2; -fx-background-radius: 15");
                tempview.setFitWidth(44);
                tempview.setFitHeight(44);
            });
            temp.setOnMouseReleased(e->
            {
                temp.setStyle("-fx-background-color: #f2f2f2; -fx-background-radius: 10");
                tempview.setFitWidth(50);
                tempview.setFitHeight(50);
            });
        }
    }
    protected void Transition(Label L)
    {
        FadeTransition transition = new FadeTransition(Duration.seconds(1.5),L);
        L.setOpacity(1);
        transition.setAutoReverse(false);
        transition.setFromValue(0);
        transition.setToValue(1.0);
        transition.setCycleCount(1);
        transition.play();
    }
    protected void EndTransition(Label L)
    {
        FadeTransition transition = new FadeTransition(Duration.seconds(1.5),L);
        transition.setAutoReverse(false);
        transition.setToValue(0);
        transition.setCycleCount(1);
        transition.play();
        transition.setOnFinished(e->{ L.setOpacity(0);});
    }
}
