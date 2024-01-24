package com.techelevator.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class Order {
    private int orderId;
    private String orderName;
    private String phoneNumber;
    private Timestamp orderDateTime = Timestamp.from(Instant.now());
    private boolean isDelivery; //= true;
    private String address;
    private Timestamp deliveryDateTime = Timestamp.from(Instant.now());

    private String paymentInfo;

    private BigDecimal totalCost;

    private String orderStatus = "pending";

    private String emailAddress;


    //constuctors
    public Order(){

    };

    public Order(int orderId, String orderName, String phoneNumber, Timestamp orderDateTime, boolean isDelivery, String address, Timestamp deliveryDateTime, String paymentInfo, BigDecimal totalCost, String orderStatus, String emailAddress) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.phoneNumber = phoneNumber;
        this.orderDateTime = orderDateTime;
        this.isDelivery = isDelivery;
        this.address = address;
        this.deliveryDateTime = deliveryDateTime;
        this.paymentInfo = paymentInfo;
        this.totalCost = totalCost;
        this.orderStatus = orderStatus;
        this.emailAddress = emailAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Timestamp orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public void setDelivery(boolean delivery) {
        isDelivery = delivery;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(Timestamp deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
