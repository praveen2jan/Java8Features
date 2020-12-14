package DesignPatterns.Creational;

public class Factory {
    public Notification createNotification(String channel){
        if("SMS".equals(channel))
            return new SMSNotification();
        else
            return new EmailNotification();
    }
}

interface Notification{
    void notifyUsers();
}

class SMSNotification implements Notification{

    public void notifyUsers() {
        System.out.println("SMS Notification");
    }
}

class EmailNotification implements Notification{

    public void notifyUsers() {
        System.out.println("Email Notification");
    }
}