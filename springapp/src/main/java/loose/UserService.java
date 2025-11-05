package loose;


public class UserService {

     public NotificationService notificationService;

    public UserService(){}

    public UserService(NotificationService notificationService)
     {
         this.notificationService=notificationService;
     }

    //  Add this setter for XML-based dependency injection
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message)
    {
        notificationService.send(message);
    }
}
