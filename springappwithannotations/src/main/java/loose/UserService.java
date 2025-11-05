package loose;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    //@Autowired
    public NotificationService notificationService;
/*
    public UserService(){}
     Auto wired is required so that spring will automatically inject this
     but if there is only one constructor we need not write @Autowired
    @Autowired
    public UserService(NotificationService notificationService)
     {
         this.notificationService=notificationService;
     }

    to resolve the conflict that which implementation class should be injected we use @Qualifier
    bean name (class name with lowercase first letter)
    public UserService(@Qualifier("emailNotificationService") NotificationService notificationService)
     {
         this.notificationService=notificationService;
     }

 */

    //Another way to resolve conflict is to annotate one of the implementations class as @primary
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
