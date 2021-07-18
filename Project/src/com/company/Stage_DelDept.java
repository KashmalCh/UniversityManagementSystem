package com.company;

public class Stage_DelDept extends Stage_ManageSubMenu{

    Stage_DelDept(String Prompt)
    {
        super(Prompt);
    }

    @Override
    protected void SetOnAction() {
        super.SetOnAction();
        done.setOnAction(e->
        {
            try {
                int did = Integer.parseInt(field.getText());
                if(Controller.DelDepartment(did)) {

                    FE_Dialog.Information("Department successfully removed","Deleted");
                    stage.close();
                }
                else
                {
                    FE_Dialog.Information("There is no such Department","Not Found");
                }
            }
            catch (NumberFormatException E)
            {
                FE_Dialog.Information("Please Enter a valid Integer","Wrong Input");
            }
            field.setText("");
        });
    }
}

