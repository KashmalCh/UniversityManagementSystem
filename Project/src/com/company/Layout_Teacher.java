package com.company;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Layout_Teacher extends Layout_ManageMenu {

    Layout_Teacher(BorderPane pane)
    {
        super();
        totalicons = 4;
        this.LoadImages();
        super.Main(pane,"Professor");
    }

    @Override
    protected void LoadImages()
    {
        try {
            iconsimage = new ImageView[totalicons];
            iconsimage[0] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\AddTeacher.png")));
            iconsimage[1] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\DelTeacher.png")));
            iconsimage[2] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\EditTeacher.png")));
            iconsimage[3] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\SearchTeacher.png")));
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
