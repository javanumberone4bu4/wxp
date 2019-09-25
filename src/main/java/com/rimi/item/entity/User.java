package com.rimi.item.entity;

import java.util.Date;

/**
 * 用户信息类
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 15:04
 */
public class User {
    private String username;
    private String password;
    private Integer id;
    private Integer telephone;
    private String email;
    private Date joinTime;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                ", joinTime=" + joinTime +
                '}';
    }
}
