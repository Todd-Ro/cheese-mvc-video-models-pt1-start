package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @NotNull
    @Size(min=5, max=15, message = "Username length must be 5 to 15")
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min=6, message = "Password should have at least 6 characters")
    private String password;

    private Integer userId;
    private static Integer nextId = 1;

    private Date date;
    private String dateString;

    public Date getDate() {
        return date;
    }
    public String getDateString() {
        return dateString;
    }

    public User() {
        this.userId = nextId;
        this.date = new Date();
        this.dateString = dateFormat.format(this.date);
        nextId++;
    }

    public User(String username) {
        this.username = username;
        this.userId = nextId;
        this.date = new Date();
        this.dateString = dateFormat.format(this.date);
        nextId++;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.userId = nextId;
        this.date = new Date();
        this.dateString = dateFormat.format(this.date);
        nextId++;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userId = nextId;
        this.date = new Date();
        this.dateString = dateFormat.format(this.date);
        nextId++;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }




}
