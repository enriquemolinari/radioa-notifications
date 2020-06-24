package notifications.model;

import java.util.Map;

import competition.model.api.Notification;
import userprofile.model.api.RadioListeners;

public class EmailNotification implements Notification {

 private static final String EMAIL = "email";
 private Queue queue;
 private RadioListeners listeners;

 public EmailNotification(Queue queue, RadioListeners listeners) {
  this.queue = queue;
  this.listeners = listeners;
 }
 
 @Override
 public void send(int idListener) {
  var listener = listeners.listener(idListener);
  var person = listener.orElseThrow(() -> new RuntimeException("idListener not found..."));
  System.out.println(person.email());
  queue.push(new DefaultMessage(idListener, Map.of(EMAIL, person.email())));
 }
}
