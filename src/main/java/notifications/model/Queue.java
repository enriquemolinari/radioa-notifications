package notifications.model;

public interface Queue {

 void push(Message item);
 
 Message pop();
 
 boolean isEmpty();
}
