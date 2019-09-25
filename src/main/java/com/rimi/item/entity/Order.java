package com.rimi.item.entity;

import java.util.Date;

/**
 * 订单信息
 *
 * @author Wang Xiaoping
 * @date 2019/9/25 7:26
 */
public class Order {
    private Integer id;
    private Integer orderNumber;
    private String orderPerson;
    private double orderSum;
    private double orderMoney;
    private String orderStatus;
    private String moneyStatus;
    private String goodStatus;
    private String moneyStyle;
    private String sendStyle;
    private Date orderTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderPerson() {
        return orderPerson;
    }

    public void setOrderPerson(String orderPerson) {
        this.orderPerson = orderPerson;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMoneyStatus() {
        return moneyStatus;
    }

    public void setMoneyStatus(String moneyStatus) {
        this.moneyStatus = moneyStatus;
    }

    public String getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(String goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getMoneyStyle() {
        return moneyStyle;
    }

    public void setMoneyStyle(String moneyStyle) {
        this.moneyStyle = moneyStyle;
    }

    public String getSendStyle() {
        return sendStyle;
    }

    public void setSendStyle(String sendStyle) {
        this.sendStyle = sendStyle;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", orderPerson='" + orderPerson + '\'' +
                ", orderSum=" + orderSum +
                ", orderMoney=" + orderMoney +
                ", orderStatus='" + orderStatus + '\'' +
                ", moneyStatus='" + moneyStatus + '\'' +
                ", goodStatus='" + goodStatus + '\'' +
                ", moneyStyle='" + moneyStyle + '\'' +
                ", sendStyle='" + sendStyle + '\'' +
                ", orderTime=" + orderTime +
                '}';
    }
}
