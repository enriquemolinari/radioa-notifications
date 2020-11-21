package notifications.model.spi;

public interface EmailProvider {

 void send(String emailTo, String emailTitle, String emailBody);

}
