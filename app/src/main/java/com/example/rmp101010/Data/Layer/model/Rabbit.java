package com.example.rmp101010.Data.Layer.model;

public class Rabbit {
    private String name;
    private String color;
    private String earlength;
    private String age;
    public Rabbit(){}
    public Rabbit(String name,String color,String earlength,String age){
        this.name=name;
        this.color=color;
        this.earlength=earlength;
        this.age=age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setEarlength(String earlength) {
        this.earlength = earlength;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public String getColor() {
        return color;
    }
    public String getName() {
        return name;
    }
    public String getEarlength() {
        return earlength;
    }
}
