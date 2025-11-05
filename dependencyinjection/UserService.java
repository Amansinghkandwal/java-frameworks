package dependencyinjection;


public class UserService {

    public NotificationService notificationService;

     public UserService(){};

     public UserService(NotificationService notificationService)
     {
         this.notificationService=notificationService;
     }

    public void notifyUser(String message)
    {
        notificationService.send(message);
    }

    public void setNotificationService(NotificationService notificationService)
    {
        this.notificationService=notificationService;
    }
}
