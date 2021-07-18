package com.company;

public class C_Department {
    protected int did;
    protected String dname;
    protected String dean_id;
    protected String hod_id;

    C_Department(String dname)
    {
        this.dname = dname;
    }
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDean_id() {
        return dean_id;
    }

    public void setDean_id(String dean_id) {
        this.dean_id = dean_id;
    }

    public String getHod_id() {
        return hod_id;
    }

    public void setHod_id(String hod_id) {
        this.hod_id = hod_id;
    }
}
