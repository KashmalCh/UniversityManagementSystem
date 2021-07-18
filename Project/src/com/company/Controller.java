package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {

    public static String GetAdminPassword(String ID)
    {
        Connection connection = SQL.getConnection();
        if(connection!=null) {
            try {
                PreparedStatement PS = connection.prepareStatement("select*from admin A where A.ID = '" + ID + "'");
                ResultSet RS = PS.executeQuery();
                RS.absolute(1);
                if(RS!=null) {
                    String Password = RS.getString(2);
                    SQL.closeConnection();
                    return Password;
                }

            } catch (SQLException E) {
                E.getMessage();
            }
        }
        SQL.closeConnection();
        return null;
    }
    public static boolean AddDepartment(String name)
    {
        Connection connection = SQL.getConnection();
        if(connection!=null)
        {
            try
            {
                ArrayList<Integer>list = DID();
                int did = FindDID(list);
                PreparedStatement PS = connection.prepareStatement("insert into department(DID,DName) value ('"+did+"','"+name+"')");
                PS.execute();
                return true;
            }
            catch (SQLException E)
            {
                FE_Dialog.Exception(E);
            }
        }
        SQL.closeConnection();
        return false;
    }
    public static boolean DelDepartment(int did)
    {
        Connection connection = SQL.getConnection();
        if(connection!=null) {
            try {

                ArrayList<Integer>list = DID();
                if(IsValidDID(list,did)) {
                    PreparedStatement PS = connection.prepareStatement("delete from department where DID = '" + did + "'");
                    PS.execute();
                    SQL.closeConnection();
                    return true;
                }
            }
            catch (SQLException E)
            {
                FE_Dialog.Exception(E);
            }
        }
        SQL.closeConnection();
        return false;
    }
    public static boolean EditDept1(int did)
    {
        ArrayList<Integer>list = DID();
        if(IsValidDID(list,did))return true;
        else return false;
    }
    public static void OnCenterofScreen(Stage stage)
    {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
    private static int FindDID(ArrayList<Integer>list)
    {
        for(int i=0; i<list.size(); i++)
        {
            if((i+1)!=list.get(i)) return (i+1);
        }
        return (list.size()+1);
    }
    private static boolean IsValidDID(ArrayList<Integer>list, int did)
    {
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == did)
                return true;}
        return false;
    }
    private static ArrayList<Integer> DID()
    {
        Connection connection = SQL.getConnection();
        ArrayList<Integer>list = new ArrayList<>();
        if(connection!=null) {
            try {
                PreparedStatement PSDID = connection.prepareStatement("select did from department");
                ResultSet RS = PSDID.executeQuery();
                RS.absolute(0);
                list = new ArrayList<Integer>();
                while (RS.next()) {
                    list.add(Integer.parseInt(RS.getString(1)));
                }
            } catch (SQLException E) {
                E.getMessage();
            }
        }
        return  list;
    }

  //.................................joining pages....................................................

    public static void OpenAffixScene(Stage stage) { FE_Affix SecondScene = new FE_Affix(stage); }
    public static void OpenWelcomeScene(Stage stage) { FE_Welcome FirstScene = new FE_Welcome(stage); }
    public static void OpenLoginScene(Stage stage) { FE_LoginPage ThirdScene = new FE_LoginPage(stage); }
    public static void OpenMainPage(Stage stage) { FE_MainPage mainPage = new FE_MainPage(stage); }
    public static void OpenStudentPage(BorderPane pane) { Layout_Student layout_student = new Layout_Student(pane); }
    public static void OpenTeacherPage(BorderPane pane) { Layout_Teacher layout_teacher = new Layout_Teacher(pane); }
    public static void OpenDeptPage(BorderPane pane) { Layout_Dept layout_dept = new Layout_Dept(pane); }
    public static void OpenCoursePage(BorderPane pane) { Layout_Course layout_course = new Layout_Course(pane); }
    public static void OpenAddDeptStage(){Stage_AddDept stage_addDept = new Stage_AddDept("Department Name");}
    public static void OpenDelDeptStage(){Stage_DelDept stage_delDept = new Stage_DelDept("Enter Department ID");}
    public static void OpenEditDeptStage(){Stage_EditDept stage_editDept = new Stage_EditDept("Enter Department ID");}
    public static void OpenSubEditDeptStage(){Stage_SubEditDept stage_subeditDept = new Stage_SubEditDept("Department New Name");}
}
