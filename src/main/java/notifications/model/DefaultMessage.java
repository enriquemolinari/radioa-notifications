package notifications.model;

import java.util.Map;

class DefaultMessage implements Message {

 private static final long serialVersionUID = 1L;

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
