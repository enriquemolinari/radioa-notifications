package notifications.spi;

public interface EmailProvider {

 void send(String emailTo, String emailTitle, String emailBody);

}
