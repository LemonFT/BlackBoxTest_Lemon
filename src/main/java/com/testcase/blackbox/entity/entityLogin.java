package com.testcase.blackbox.entity;

public class entityLogin {
    private String name, pass;
    public entityLogin(String name, String pass){
        this.name = name;
        this.pass = pass;
    }
    public String getName(){
        return this.name;
    }
    public String getPass(){
        return this.pass;
    }
}