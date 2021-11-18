package com.example.bailt2;

public class Model_User {
    public int ID;
    public String username,password,fullname;
    public int phone;
    public String birth;
    int ID_group;

    public Model_User() {
    }

    public Model_User(int ID, String username, String password, String fullname, int phone, String birth, int ID_group) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.birth = birth;
        this.ID_group = ID_group;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getID_group() {
        return ID_group;
    }

    public void setID_group(int ID_group) {
        this.ID_group = ID_group;
    }
}
