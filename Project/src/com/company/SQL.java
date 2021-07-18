package com.company;

import java.sql.*;

import java.sql.DriverManager;

public  class SQL {

    static Connection connection = null;
    String connectionUrl = "jdbc:mysql://localhost:3306/bank";
    String connectionUser = "admin";
    String connectionPassword = "root";


    public SQL(){

    }

    public static Connection getConnection () {

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","");
            return connection;
        }
        catch(Exception E){
            FE_Dialog.Exception(E);
        }
        return null;
    }
    public static void closeConnection()
    {
        try {
            connection.close();
        }
        catch (SQLException E)
        {
            FE_Dialog.Exception(E);
        }

    }
}