package main;

import competition.model.api.Notification;
import notifications.model.EmailNotification;
import notifications.persistence.BigQueueNotification;

public class Main {

 public static void main(String[] args) {
  Notification n = new EmailNotification(
    new BigQueueNotification("/home/enrique", "test1"));
  n.send(1);
 }
}
