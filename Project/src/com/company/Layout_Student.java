package com.company;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Layout_Student extends Layout_ManageMenu {


    Layout_Student(BorderPane pane)
    {
        super();
        totalicons = 4;
        this.LoadImages();
        super.Main(pane,"Student");
    }

    @Override
    protected void LoadImages()
    {
        try {
            iconsimage = new ImageView[totalicons];
            iconsimage[0] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\AddStudent.png")));
            iconsimage[1] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\DelStudent.png")));
            iconsimage[2] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\EditStudent.png")));
            iconsimage[3] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\SearchStudent.png")));
        }
        catch (FileNotFoundException E)
        {
            FE_Dialog.Exception(E);
        }
    }

    @Override
    protected void SetOnAction() {
        super.SetOnAction();

    }
}


