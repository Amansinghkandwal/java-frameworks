package bean;

import loose.NotificationService;


public class LifeCycleBean{

    private NotificationService notificationService;


    public LifeCycleBean(NotificationService notificationService)
    {

        System.out.println("Constructor Called: Dependency Injected");
        this.notificationService = notificationService;
    }

    public void init()
    {
        System.out.println("init called: Bean initialized");
        notificationService.send("Hello from init()");
    }

    public void performTask()
    {
        System.out.println("Ready for use");
    }

    public void cleanUp()
    {
        System.out.println("Cleanup() being called");
    }
}
