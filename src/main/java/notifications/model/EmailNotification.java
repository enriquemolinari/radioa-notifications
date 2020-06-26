package notifications.model;

import java.util.Map;

import competition.model.api.Notification;
import userprofile.model.api.RadioListeners;

public class EmailNotification implements Notification {

 private Queue queue;
 private RadioListeners listeners;

 public EmailNotification(Queue queue, RadioListeners listeners) {
  this.queue = queue;
  this.listeners = listeners;
 }

 @Override
 public void send(int idListener, String message) {
  var listener = listeners.listener(idListener);
  var person = listener
    .orElseThrow(() -> new RuntimeException("idListener not found..."));
  queue
    .push(new DefaultMessage(idListener, Map.of(DefaultMessage.EMAIL_ITEM,
      person.email(), DefaultMessage.MSG_ITEM, message)));
 }
}
