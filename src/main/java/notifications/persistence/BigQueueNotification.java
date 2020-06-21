package notifications.persistence;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.leansoft.bigqueue.BigQueueImpl;
import com.leansoft.bigqueue.IBigQueue;

import notifications.model.Queue;
import notifications.model.QueueItem;

public class BigQueueNotification implements Queue {

 private IBigQueue bigQueue;
 
 public BigQueueNotification(String queueFilePath, String queueName) {
  try {
   bigQueue = new BigQueueImpl(queueFilePath, queueName);
  } catch (IOException e) {
   throw new RuntimeException("BigQueue cannot be instantiated...", e);
  }
 }
 
 @Override
 public void push(QueueItem item) {
  try {
   ByteArrayOutputStream out = new ByteArrayOutputStream();
   ObjectOutputStream os = new ObjectOutputStream(out);
   os.writeObject(item);
   this.bigQueue.enqueue(out.toByteArray());
  } catch (IOException e) {
   throw new RuntimeException("Cannot serialize QueueItem...", e);
  }
 }

 @Override
 public QueueItem pop() {
  try {  
   ByteArrayInputStream in = new ByteArrayInputStream(this.bigQueue.dequeue());
   ObjectInputStream is = new ObjectInputStream(in);
   return (QueueItem)is.readObject();
  } catch (IOException | ClassNotFoundException e) {
   throw new RuntimeException("Cannot deserialize QueueItem...", e);
  }
 }

 @Override
 public boolean isEmpty() {
  return this.bigQueue.isEmpty();
 }
}
