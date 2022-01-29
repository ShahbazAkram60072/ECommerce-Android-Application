package com.shahbaz.rentadressapplicationsemesterproject.JavaClass;

public class Favorite_Product {
    public String pid,imageUrl,date,time,rent,pname,description;

    public Favorite_Product() {
    }


    public Favorite_Product(String pid, String imageUrl, String date, String time, String rent, String pname, String description) {
        this.pid = pid;
        this.imageUrl = imageUrl;
        this.date = date;
        this.time = time;
        this.rent = rent;
        this.pname = pname;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
