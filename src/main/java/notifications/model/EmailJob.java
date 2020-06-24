package notifications.model;

public class EmailJob {
 private Queue queue;
 private EmailProvider provider;

 public EmailJob(Queue queue, EmailProvider provider) {
  this.queue = queue;
  this.provider = provider;
 }

 public void sendThemAll() {
  while(!this.queue.isEmpty()) {
   Message m = this.queue.pop();
   provider.send(m.itemValue("email"));
  }
 }
}
