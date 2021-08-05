package com.bean;

public class Table1 {
    private int id;
    private String bid;
    private String xtname;
    private  int number;
    private String level;
    private String bugurl;
    private String bugtype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getXtname() {
        return xtname;
    }

    public void setXtname(String xtname) {
        this.xtname = xtname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBugurl() {
        return bugurl;
    }

    public void setBugurl(String bugurl) {
        this.bugurl = bugurl;
    }

    public String getBugtype() {
        return bugtype;
    }

    public void setBugtype(String bugtype) {
        this.bugtype = bugtype;
    }

    @Override
    public String toString() {
        return "Table1{" +
                "id=" + id +
                ", bid='" + bid + '\'' +
                ", xtname='" + xtname + '\'' +
                ", number=" + number +
                ", level='" + level + '\'' +
                ", bugurl='" + bugurl + '\'' +
                ", bugtype='" + bugtype + '\'' +
                '}';
    }
}
