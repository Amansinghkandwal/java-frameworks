package main;

import bean.GreetingService;
import loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args)
    {

        //Inversion of control -- we have given the control to the spring
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationBeanContext.xml");
        GreetingService greetingService=(GreetingService) context.getBean("myBean");
        greetingService.sayHello();

        UserService userServiceEmail =(UserService) context.getBean("userServiceEmail");
        userServiceEmail.notifyUser("Hey there!");
        UserService userServiceSMS =(UserService) context.getBean("userServiceSMS");
        userServiceSMS.notifyUser("Hey there!");

    }
}
