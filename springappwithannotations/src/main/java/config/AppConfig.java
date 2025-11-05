package config;


import bean.LifeCycleBean;
import loose.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"bean","loose"}) //This is required to tell java where to go to find bean
public class AppConfig {

    @Bean(initMethod = "init",destroyMethod = "cleanUp")
    public LifeCycleBean lifeCycleBean(NotificationService notificationService)
    {
        return new LifeCycleBean(notificationService);
    }
  //It is an alternative when you cannot modify the classes you will use @Bean and then the returned object
  // from the class is managed by spring

//    @Component is used on a class to tell Spring, “Hey, automatically detect and manage this class as a bean during
//    component scanning.” You typically use it when the class is your own — like a service,
//    repository, or controller.
//    @Bean, on the other hand, is used on a method inside a @Configuration class. It tells Spring,
//    “The object returned by this method should be registered as a bean.” You usually use @Bean when
//    you can’t annotate the class directly, such as when it’s from a third-party
//    library or when you need custom initialization logic.

//    @Component = automatic bean detection through classpath scanning.
//    @Bean = manual bean creation inside a configuration class.


}
