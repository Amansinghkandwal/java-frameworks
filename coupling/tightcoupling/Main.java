package coupling.tightcoupling;

public class Main {

    public static void main(String[] args)
    {
        UserService userService=new UserService();

        userService.notifyUser("You are verified!");

    }
}
