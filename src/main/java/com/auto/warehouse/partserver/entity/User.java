package com.auto.warehouse.partserver.entity;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class User {

    private Integer userId;

    private String name;

    private String pwd;

    private Date pwdExpDate;

    private String email;

    private String tel;

    private String description;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getPwdExpDate() {
        return pwdExpDate;
    }

    public void setPwdExpDate(Date pwdExpDate) {
        this.pwdExpDate = pwdExpDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
