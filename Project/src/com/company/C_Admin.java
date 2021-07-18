package com.company;

import javax.swing.*;

public class C_Admin {

    private String ID;
    private String Password;

    C_Admin(String ID , String Password)
    {
        this.ID = ID;
        this.Password = Password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean IsPasswordMatch(String Pass)
    {
        if(Pass.equals( this.Password)) return  true;
        return  false;
    }
    public boolean IsIdMatch(String ID)
    {
        if(ID == this.ID) return true;
        return false;
    }
}
