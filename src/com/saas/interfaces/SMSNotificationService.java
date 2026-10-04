package com.saas.interfaces;

public class SMSNotificationService implements NotificationServices{
    public void sendEmail(String recipient, String message){
        System.out.println("Email requested but SMSNotificationService delegates or logs : Cannot send Email via SMS service");
    }
    public void sendNotification(String recipient, String message){
        System.out.println("Sending SMS to "+recipient+" : "+message);
    }
}
