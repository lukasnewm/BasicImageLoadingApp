package com.example.lukas.inclass03;

import java.io.Serializable;

public class User implements Serializable{
    String name;
    String email;
    String phoneNumber;
    String address;
    String mood;

    public User (String name, String email, String phone, String address, String mood)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phone;
        this.address = address;
        this.mood = mood;
    }

    public void setName(String name){
        this.name = name;

    }

    public void setEmail(String email){
        this.email = email;

    }

    public void setAddress(String address){
        this.address = address;

    }

    public void setPhoneNumber(String phone){
        this.phoneNumber = phone;

    }

    public void setMood(String mood){
        this.mood = mood;

    }

    public String getName(){
        return this.name;

    }

    public String getEmail(){
        return this.email;

    }

    public String getAddress(){
        return this.address;

    }

    public String getPhoneNumber(){
        return this.phoneNumber;

    }

    public String getMood(){
        return this.mood;

    }
}
