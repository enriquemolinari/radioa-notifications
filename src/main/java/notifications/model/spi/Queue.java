package notifications.model.spi;

public interface Queue {

 void push(Message item);
 
 Message pop();
 
 boolean isEmpty();
}
