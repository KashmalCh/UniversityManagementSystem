package com.company;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Layout_Home {

    protected StackPane cpane;
    protected GridPane gridPane;
    protected Button[]icons;
    protected ImageView[] iconsimage;
    protected int totalicons;

    Layout_Home()
    {

    }
    Layout_Home(BorderPane pane)
    {

        cpane = new StackPane();
        cpane.setStyle("-fx-background-color: white");
        cpane.setPadding(new Insets(100,150,100,150));
        totalicons = 16;

        HandleIcons();
        cpane.getChildren().add(gridPane);
        pane.setCenter(cpane);
    }

    public Button getIcons(int index) {
        if(index<totalicons)
            return icons[index];
        return null;
    }

    public ImageView[] getIconsimage() {
        return iconsimage;
    }

    private void HandleIcons()
    {
        try {
            iconsimage = new ImageView[totalicons];
            iconsimage[0] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Student.png")));
            iconsimage[1] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Teacher.png")));
            iconsimage[2] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Department.png")));
            iconsimage[3] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Courses.png")));
            iconsimage[4] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Library.png")));
            iconsimage[5] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Bus.png")));
            iconsimage[6] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Societies.png")));
            iconsimage[7] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Events.png")));
            iconsimage[8] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\ScholarShip.png")));
            iconsimage[9] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Sports.png")));
            iconsimage[10] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Cafe.png")));
            iconsimage[11] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Hostel.png")));
            iconsimage[12] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Staff.png")));
            iconsimage[13] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Security.png")));
            iconsimage[14] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\Alumni.png")));
            iconsimage[15] = new ImageView(new Image(new FileInputStream("E:\\JavaProject\\Images\\AdminPanel.png")));
            icons = new Button[totalicons];
            for(int i=0; i<totalicons; i++) {
                icons[i] = new Button("",iconsimage[i]);
                icons[i].setPrefSize(170,100);
                icons[i].setStyle("-fx-background-color: #f2f2f2; -fx-background-radius: 10");
                iconsimage[i].setFitHeight(50);
                iconsimage[i].setFitWidth(50);
            }
            gridPane = new GridPane();
            for(int j=0; j<4; j++) {
                for (int k = 0; k <4; k++) {
                    GridPane.setConstraints(icons[(j*4)+k],k,j);
                }
            }
            gridPane.getChildren().addAll(icons);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setStyle("-fx-background-color: #d8d8d8");
            gridPane.setHgap(20);
            gridPane.setVgap(20);
            gridPane.setPadding(new Insets(60,0,60,0));
        }
        catch (FileNotFoundException E)
        {
            FE_Dialog.Exception(E);
        }


    }
}
