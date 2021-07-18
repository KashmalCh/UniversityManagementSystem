package com.company;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Layout_Dept extends Layout_ManageMenu {

    Layout_Dept(BorderPane pane)
    {
        super();
        totalicons = 4;
        this.LoadImages();
        super.Main(pane,"Department");
    }

    @Override
    protected void LoadImages()
    {
        try {
            iconsimage = new ImageView[totalicons];
            iconsimage[0] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\AddDept.png")));
            iconsimage[1] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\DelDept.png")));
            iconsimage[2] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\EditDept.png")));
            iconsimage[3] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\SearchDept.png")));
        }
        catch (FileNotFoundException E)
        {
            FE_Dialog.Exception(E);
        }
    }
    @Override
    protected void SetOnAction() {
        super.SetOnAction();
        for(int i=0; i<totalicons; i++)
        {
            Button temp = icons[i];
            temp.setOnAction(e->
            {
                if((temp==icons[0]))
                {
                    Controller.OpenAddDeptStage();
                }
                else if(temp==icons[1])
                {
                    Controller.OpenDelDeptStage();
                }
                else if(temp==icons[2])
                {
                    Controller.OpenEditDeptStage();
                }

            });
        }
    }
}
