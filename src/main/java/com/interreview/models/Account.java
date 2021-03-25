package com.interreview.models;

import javax.persistence.Column;
import javax.validation.constraints.Email;

public class Account {

    @Column(unique = true)
    private String userName;
    @Email(message = "Please enter a valid email address")
    @Column(unique = true)
    private String email;
    private String password;
    private String fName;
    private String lName;

    public Account() {
        this.userName = "";
        this.email = "";
        this.password = "";
        this.fName = "";
        this.lName = "";
    }

    public Account(String userName, String email, String password, String fName, String lName) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
