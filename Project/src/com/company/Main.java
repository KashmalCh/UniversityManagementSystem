package com.company;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
	    launch(args);
    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        PrimaryStage.centerOnScreen();
        PrimaryStage.setResizable(false);
        PrimaryStage.setHeight(740);
        PrimaryStage.setWidth(1390);
        Controller.OpenWelcomeScene(PrimaryStage);
        PrimaryStage.show();
    }
}
