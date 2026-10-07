package com.saas.training.notificationservice;

public class EmailNotificationService implements NotificationService{
    public void sendNotification(String message){
        System.out.println("Email Notification :"+message);
    }
}
