package notifications.model;

public interface Queue {

 void push(QueueItem item);
 
 QueueItem pop();
 
 boolean isEmpty();
}
