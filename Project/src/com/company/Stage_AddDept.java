package com.company;

public class Stage_AddDept extends Stage_ManageSubMenu {

    Stage_AddDept(String Prompt){
        super(Prompt);
    }

    @Override
    protected void SetOnAction() {
        super.SetOnAction();
        done.setOnAction(e->{
            String dname = field.getText();
            if(Controller.AddDepartment(dname)){
                FE_Dialog.Information("Department Added","Confirmation");
                stage.close();
            }
            else
                FE_Dialog.Information("Can't Add Department","Error");
                stage.close();
        });
    }
}