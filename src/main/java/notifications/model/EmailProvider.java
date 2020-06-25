package notifications.model;

public interface EmailProvider {

 void send(String emailTo, String emailTitle, String emailBody);

}
