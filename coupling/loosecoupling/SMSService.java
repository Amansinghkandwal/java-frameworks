package coupling.loosecoupling;

public class SMSService implements NotificationService{

    @Override
    public void send(String message) {
        System.out.println("SMS : "+message);
    }
}
