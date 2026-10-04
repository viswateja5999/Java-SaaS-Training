package com.saas.interfaces;

public interface NotificationServices{
    void sendEmail(String recipient, String message);
    void sendNotification(String recipient, String message);
}



