package coupling.loosecoupling;


public class Main {
    public static void main(String[] args)
    {
        NotificationService emailService = new EmailNotificationService();
        NotificationService smsService = new SMSService();
        UserService userService = new UserService(emailService);
        userService.notifyUser("Hey there!");
        userService = new UserService(smsService);
        userService.notifyUser("Hey there!!");
    }

}
