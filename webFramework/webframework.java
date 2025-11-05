package webFramework;

public class webframework {

    public static void main(String[] args)
    {
        /*
        Problems without a framework
        Imagine building a web app from scratch
        (HTTP, routing ,sessions , JSON , etc):
        * Handling incoming HTTP requests manually
        * Parse query parameters
        * Manage responses (status codes,headers)
        * Maintain sessions or cookies
        * Error handling and logging
        * Connect to databases
         */

        /*
        With Framework
        * Reduces boilerplate code
        * Provides structure architecture
        * Handles common tasks automatically
        * Makes your app more maintainable , testable , scalable
         */

        /*
        Benefits of Spring
        * Loose Coupling
        * Maintainability
        * Scalability
        * Reduce Boilerplate
         */

        //SPRING CONCEPTS
        /*
        Bean
        A bean is just a java object that spring manages for you

        Spring Container (Ioc Container)
        The Container is the brain of Spring. Its responsible for:
        * Creating all beans
        * Injecting their dependencies
        * Managing their lifecycle

        Inversion of Control(Ioc)
        Normally your code controls when and how objects are created.
        With spring , you give up that control -- Spring takes over and creates objects for you

        Application Context
        This is the main Spring container implementation
        It knows every bean, manages them, and resolve dependencies
         */

    }
}
