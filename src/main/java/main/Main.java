package main;

import notifications.model.Message;
import notifications.model.Queue;
import notifications.persistence.BigQueueNotification;

public class Main {

 public static void main(String[] args) {
//  Notification n = new EmailNotification(
//    new BigQueueNotification("/home/enrique", "test1"));
//  n.send(1);
  
  Queue q = new BigQueueNotification("/home/enrique", "test1");
  Message qi = (Message)q.pop();
  System.out.println(qi.listenerId());
  System.out.println(qi.itemValue("email"));
    
 }
}
