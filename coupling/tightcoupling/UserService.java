package coupling.tightcoupling;

public class UserService {

    NotificationService notificationService=new NotificationService();
    public void notifyUser(String message)
    {
        notificationService.sendMessage("Notification : Hello there!");
    }
}
