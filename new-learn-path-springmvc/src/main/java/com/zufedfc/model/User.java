package com.zufedfc.model;

public class User {

    // name,password,phone
    private String name;
    private String password;
    private String phone;

    public User() {
        super();
    }

    public User(String name, String password, String phone) {
        super();
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
