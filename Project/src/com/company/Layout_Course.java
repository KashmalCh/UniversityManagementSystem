package com.company;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Layout_Course extends Layout_ManageMenu {

    Layout_Course(BorderPane pane)
    {
        super();
        totalicons = 4;
        this.LoadImages();
        super.Main(pane,"Course");
    }

    @Override
    protected void LoadImages()
    {
        try {
            iconsimage = new ImageView[totalicons];
            iconsimage[0] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\AddCourse.png")));
            iconsimage[1] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\DelCourse.png")));
            iconsimage[2] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\EditCourse.png")));
            iconsimage[3] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\SearchCourse.png")));
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
