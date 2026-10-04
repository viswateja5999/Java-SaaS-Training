package com.saas.interfaces;

public class EmailNotificationService implements NotificationServices {
    public void sendEmail(String recipient, String message){
        System.out.println("Sending Email to "+recipient+" : "+message);
    }
    public void sendNotification(String recipient, String message){
        sendEmail(recipient, message);
    }
}

