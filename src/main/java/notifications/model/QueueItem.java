package notifications.model;

import java.util.Map;

public class QueueItem {

 private int idListener;
 private Map<String, String> items;
 
 public QueueItem(int idListener, Map<String, String> items) {
  this.idListener = idListener;
  this.items = items;
 }
 
 public int id() {
  return idListener;
 }
 
 public String itemValue(String itemKey) {
  return this.items.get(itemKey);
 }
}
