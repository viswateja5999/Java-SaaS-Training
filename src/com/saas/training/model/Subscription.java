package com.saas.training.model;

public class Subscription {
    private int subscriptionId;
    private String planName;
    private double monthlyPrice;
    private int maxEmployee;

    public Subscription(int subscriptionId, String planName, double monthlyPrice, int maxEmployee){
        this.subscriptionId = subscriptionId;
        this.planName= planName;
        this.monthlyPrice= monthlyPrice;
        this.maxEmployee=maxEmployee;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionId=" + subscriptionId +
                ", planName='" + planName + '\'' +
                ", monthlyPrice=" + monthlyPrice +
                ", maxEmployee=" + maxEmployee +
                '}';
    }

    public String getPlanName() {
        return planName;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public int getMaxEmployee() {
        return maxEmployee;
    }


}
