package notifications.model;

import java.util.Map;

class DefaultMessage implements Message {

 private static final long serialVersionUID = 1L;
 public static final String EMAIL_ITEM = "email";
 public static final String MSG_ITEM = "message";
 
 private int idListener;
 private Map<String, String> items;
 
 public DefaultMessage(int idListener, Map<String, String> items) {
  this.idListener = idListener;
  this.items = items;
 }
 
 @Override
 public int listenerId() {
  return idListener;
 }
 
 @Override
 public String itemValue(String itemKey) {
  return this.items.get(itemKey);
 }
}
