package notifications.model;

import notifications.model.spi.EmailProvider;
import notifications.model.spi.Message;
import notifications.model.spi.Queue;

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
   System.out.println(m.listenerId());
   System.out.println(m.itemValue(DefaultMessage.EMAIL_ITEM));
   System.out.println(m.itemValue(DefaultMessage.MSG_ITEM));
   provider.send(m.itemValue(DefaultMessage.EMAIL_ITEM), EMAIL_TITLE,
     m.itemValue(DefaultMessage.MSG_ITEM));
  }
 }
}
