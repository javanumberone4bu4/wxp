package com.rimi.item.entity;

/**
 * 会员信息
 *
 * @author Wang Xiaoping
 * @date 2019/9/25 16:24
 */
public class Member {
private Integer id;
private String username;
private String sex;
private Integer telephone;
private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone=" + telephone +
                ", address='" + address + '\'' +
                '}';
    }
}
