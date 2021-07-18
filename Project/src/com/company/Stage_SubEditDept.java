package com.company;

import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.web.PromptData;

public class Stage_SubEditDept extends Stage_ManageSubMenu {

    TextField hod;
    TextField dean;
    Separator []separator;
    Stage_SubEditDept(String Prompt)
    {
        super(Prompt);
        stage.setHeight(450);
        background.setFitHeight(400);
        background.setFitWidth(800);
        Controller.OnCenterofScreen(stage);


    }
    @Override
    protected void SetOnAction() {
        super.SetOnAction();
    }

}
