package com.saas.domain;

public class Subscription {
    private long id;
    private String planName;
    private double price;
    private String status;

    public Subscription(){

    }

    public Subscription(long id, String planName, double price, String status){
        this.id = id;
        this.planName = planName;
        this.price = price;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
