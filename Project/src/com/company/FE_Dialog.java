package com.company;

import javafx.scene.control.Alert;
import javafx.stage.Modality;

public class FE_Dialog {
    public static Alert alert;

    public static void Exception(Exception E )
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("There is an Exception");
        alert.setContentText(E.getMessage());
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }
    public static void Information(String Message, String Title)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Title);
        alert.setHeaderText(null);
        alert.setContentText(Message);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }

}
