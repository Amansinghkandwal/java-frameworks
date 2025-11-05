package bean;

import org.springframework.stereotype.Component;

@Component("myBean")
public class GreetingService {

    //@Component is used to mark it as a bean

    public void sayHello()
    {
        System.out.println("Hello World");
    }
}
