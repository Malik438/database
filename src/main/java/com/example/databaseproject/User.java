package com.example.databaseproject;

public class User {

    String userName;
    String lastName ;
    String passowrd ;
    String email ;
    int age ;
    int user_id;
    String user_type ;

    public User(String fistName, String lastName, String passowrd, String email, int age, int user_id, String user_type) {
        this.userName = fistName;
        this.lastName = lastName;
        this.passowrd = passowrd;
        this.email = email;
        this.age = age;
        this.user_id = user_id;
        this.user_type = user_type;
    }

    public User(String fistName, String lastName, String passowrd, String email, int age, String user_type) {
        this.userName = fistName;
        this.lastName = lastName;
        this.passowrd = passowrd;
        this.email = email;
        this.age = age;
        this.user_type = user_type;
    }

    public User(String fistName){
        this.userName = fistName;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}

