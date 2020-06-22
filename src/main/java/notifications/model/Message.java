package notifications.model;

import java.io.Serializable;

public interface Message extends Serializable {

 int listenerId();

 String itemValue(String key);
}
