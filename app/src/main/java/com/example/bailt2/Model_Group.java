package com.example.bailt2;

public class Model_Group {
    public int ID;
    public String name;

    public Model_Group() {
    }

    public Model_Group(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
