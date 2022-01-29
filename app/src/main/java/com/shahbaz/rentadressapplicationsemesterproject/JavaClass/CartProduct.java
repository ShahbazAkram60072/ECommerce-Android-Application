package com.shahbaz.rentadressapplicationsemesterproject.JavaClass;

public class CartProduct {
    public String pid,imageUrl,date,time,rent,pname,pcode,userID;

    public CartProduct() {
    }

    public CartProduct(String pid, String imageUrl, String date, String time, String rent, String pname, String pcode, String userID) {
        this.pid = pid;
        this.imageUrl = imageUrl;
        this.date = date;
        this.time = time;
        this.rent = rent;
        this.pname = pname;
        this.pcode = pcode;
        this.userID = userID;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
