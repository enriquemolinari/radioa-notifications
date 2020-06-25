package notifications.model;

public class EmailJob {
 private static final String EMAIL_TITLE = "RadioA Notification";
 private Queue queue;
 private EmailProvider provider;

 public EmailJob(Queue queue, EmailProvider provider) {
  this.queue = queue;
  this.provider = provider;
 }

 public void sendThemAll() {
  while (!this.queue.isEmpty()) {
   Message m = this.queue.pop();
   provider.send(m.itemValue(DefaultMessage.EMAIL_ITEM), EMAIL_TITLE,
     m.itemValue(DefaultMessage.MSG_ITEM));
  }
 }
}
