package com.company;

import com.mysql.cj.log.Log;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class FE_MainPage {

    private Scene scene;
    private Label tblabel;
    private HBox topbar;
    private HBox logoutcover;
    private Image logoutimage;
    private Image logoutimage2;  // when mouse entered
    private ImageView logoutimageview;
    private ImageView logoutimageview2;
    private VBox menu;
    private Button logout;
    private StackPane lpane;
    private Label toplabel;
    private Button []menuitems;
    private int items;
    BorderPane mainpane;
    Layout_Home Home;

    FE_MainPage(Stage stage)
    {
        try {


            stage.setTitle("University of Central Punjab");
            mainpane = new BorderPane();
            items = 17;

            topbar = new HBox();
            topbar.prefWidthProperty().bind(stage.widthProperty());
            topbar.setStyle("-fx-background-color: #161928");
            topbar.setPrefHeight(50);


            logoutimage = new Image(new FileInputStream("E:\\JavaProject\\Images\\logoutNormal.png"));
            logoutimageview = new ImageView(logoutimage);
            logoutimage2 = new Image(new FileInputStream("E:\\JavaProject\\Images\\logoutPressed.png"));
            logoutimageview2 = new ImageView(logoutimage2);
            logoutimageview.setFitWidth(20);
            logoutimageview.setFitHeight(20);
            logoutimageview2.setFitWidth(20);
            logoutimageview2.setFitHeight(20);
            logout = new Button("Log Out",logoutimageview);
            logout.setPrefSize(100,40);
            logout.setStyle("-fx-background-color: transparent; -fx-font-family: Times; -fx-text-fill: lightgray");

            logoutcover = new HBox();
            logoutcover.getChildren().add(logout);
            logoutcover.setPadding(new Insets(8,0,0,1070));



            menu = new VBox();
            menu.prefHeightProperty().bind(stage.heightProperty());
            menu.setPrefWidth(180);
            double startmenuX = (menu.getTranslateX() - 150);
            double endmenuX = menu.getTranslateX()-10;
            menu.setTranslateX(startmenuX);
            menu.setStyle("-fx-background-color: white");
            menu.setPadding(new Insets(35,0,0,0));
            menu.setSpacing(3);

            //TopBorder Label
            tblabel = new Label("Administrator");
            tblabel.prefWidthProperty().bind(menu.widthProperty());
            tblabel.prefHeightProperty().bind(topbar.heightProperty());
            tblabel.setStyle("-fx-background-color: #0d0e16; -fx-text-fill: lightgray; -fx-font-size: 23px Comic SansMS" +
                    "; -fx-font-family: 'Times'");
            tblabel.setPadding(new Insets(10, 0, 0, 18));
            topbar.getChildren().addAll(tblabel,logoutcover);

            this.Setmenuitems();
            menu.getChildren().addAll( menuitems);


            lpane = new StackPane();
            lpane.setStyle("-fx-background-color: white");
            lpane.getChildren().add(menu);



            mainpane.setTop(topbar);
            mainpane.setLeft(lpane);
            Home = new Layout_Home(mainpane);
            this.MenuTransitions(startmenuX, endmenuX);
            this.SetOnAction(stage);
            scene = new Scene(mainpane);
            scene.setFill(Color.rgb(255,255,255));
            stage.setScene(scene);
        }
        catch (FileNotFoundException E)
        {
            FE_Dialog.Exception(E);
        }
    }
    private void SetOnAction(Stage stage)
    {
        logout.setOnMouseEntered(e->{logout.setGraphic(logoutimageview2);});
        logout.setOnMouseExited(e->{logout.setGraphic(logoutimageview);});
        logout.setOnMouseClicked(e->{Controller.OpenLoginScene(stage);});
        logout.setOnMousePressed(e->{
            logoutimageview2.setFitWidth(18);
            logoutimageview2.setFitHeight(18);
            ;});
        logout.setOnMouseReleased(e->{
            logoutimageview2.setFitWidth(20);
            logoutimageview2.setFitHeight(20);
            Controller.OpenLoginScene(stage);
            ;});

        //..................GETTING ICON ARRAY FROM LAYOUT_HOME
        Button [] icons  = new Button[17];                      //Highlights
        for(int ic=1; ic<17; ic++) {
            icons[ic] = Home.getIcons(ic-1);
        }
        icons[0] = new Button();
        //.............................................................................

       for(int i=0; i<items; i++)
       {
            Button mybutton = menuitems[i];
            Button myicon = icons[i];

           mybutton.setOnMouseEntered(e-> {
               mybutton.setEffect(new InnerShadow(20, Color.TEAL));
               Effect effect1 = new InnerShadow(20,Color.DARKSLATEGRAY);
               Effect effect2 = new Glow(0.4);
               ((InnerShadow) effect1).setInput(effect2);
               myicon.setEffect(effect1);

               });
           mybutton.setOnMouseExited(e->
           {
               mybutton.setEffect(new InnerShadow(0, Color.TEAL));
               Effect effect1 = new InnerShadow(0,Color.DARKSLATEGRAY);
               Effect effect2 = new Glow(0);
               ((InnerShadow) effect1).setInput(effect2);
               myicon.setEffect(effect2);
           });
           mybutton.setOnMousePressed(e->
           {
               mybutton.setStyle("-fx-background-color: #10213d; -fx-font-size: 13px Comic SansMS; -fx-text-fill: lightgray " +
                       "; -fx-font-family: 'Times'; -fx-background-radius: 13");
           });
           mybutton.setOnMouseReleased(e->
           {
               mybutton.setStyle("-fx-background-color: #10213d; -fx-font-size: 15px Comic SansMS; -fx-text-fill: lightgray " +
                       "; -fx-font-family: 'Times'; -fx-background-radius: 10");
           });
           mybutton.setOnAction(e->
           {
               String Text = mybutton.getText();
               if(Text=="Home")
                   Controller.OpenMainPage(stage);
               else if(Text=="Students")
                   Controller.OpenStudentPage(mainpane);
               else if(Text=="Professors")
                   Controller.OpenTeacherPage(mainpane);
               else if(Text=="Departments")
                   Controller.OpenDeptPage(mainpane);
               else if(Text=="Courses")
                   Controller.OpenCoursePage(mainpane);
           });
       }
    }
    private void MenuTransitions(double startmenuX, double endmenuX)
    {
        tblabel.setOnMouseExited(e->
        {
            Transition(startmenuX);
        });
        tblabel.setOnMouseEntered(e->
        {
            Transition(endmenuX);
        });
        menu.setOnMouseExited(e->
        {
            Transition(startmenuX);
        });
        menu.setOnMouseEntered(e->
        {
            Transition(endmenuX);
        });

    }
    private void Transition(double menuX)
    {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(menu);
        transition.setDuration(Duration.seconds(1));
        transition.setFromX(menu.getTranslateX());
        transition.setToX((menuX));
        transition.play();
    }
    private void Setmenuitems()
    {

        menuitems = new Button[items];
        for(int i=0; i<items; i++)
            menuitems[i] = new Button();
        for(int j=0; j<items; j++)
        {
            menuitems[j].setStyle("-fx-background-color: #10213d; -fx-font-size: 15px Comic SansMS; -fx-text-fill: lightgray " +
                    "; -fx-font-family: 'Times'; -fx-background-radius: 10");
            menuitems[j].prefWidthProperty().bind(menu.widthProperty());
        }
        menuitems[0].setText("Home");
        menuitems[1].setText("Students");
        menuitems[2].setText("Professors");
        menuitems[3].setText("Departments");
        menuitems[4].setText("Courses");
        menuitems[5].setText("Library");
        menuitems[6].setText("Transport");
        menuitems[7].setText("Societies");
        menuitems[8].setText("Events");
        menuitems[9].setText("Scholarships");
        menuitems[10].setText("Sports");
        menuitems[11].setText("Cafeteria");
        menuitems[12].setText("Hostel");
        menuitems[13].setText("Staff");
        menuitems[14].setText("Security");
        menuitems[15].setText("Alumni");
        menuitems[16].setText("Admin Panel");
    }
}
