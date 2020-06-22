package notifications.model;

import java.util.Map;

import competition.model.api.Notification;

public class EmailNotification implements Notification {

 private Queue queue;

 public EmailNotification(Queue queue) {
  this.queue = queue;
 }
 
 @Override
 public void send(int idListener) {
  // TODO: traer email de userprofile
  queue.push(new DefaultMessage(idListener, Map.of("email", "e@bla.com")));
 }
}
