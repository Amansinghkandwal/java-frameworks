package dependencyinjection;


public class Main {
    public static void main(String[] args)
    {
       /*
       Constructor Injection - dependency is provided via constructor
       Setter Injection - dependency is provided via setter method
       Field Injection - dependency is assigned directly to a field
        */
        //Example of Constructor Injection
        NotificationService emailService = new EmailNotificationService();
        UserService userService = new UserService(emailService);
        userService.notifyUser("Hey there!");

        //Example of Setter Injection
        UserService userServiceLooseSetter = new UserService();
        userServiceLooseSetter.setNotificationService(emailService);
        userService.notifyUser("Hey there!!");

        //Example of Field Injection
        userServiceLooseSetter.notificationService=emailService;
        userServiceLooseSetter.notifyUser("Hey there !!!");

    }

}
