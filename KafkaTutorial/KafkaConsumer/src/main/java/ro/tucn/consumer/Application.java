package ro.tucn.consumer;

/**
 * Created by Liviu on 3/31/2017.
 */
public class Application {

    public static void main(String[] args) {
        /*if(args.length > 0) {
            if(args[0].equals("test")) {
                System.out.println("Entering test mode");
                new Consumer().run();
                return;
            }
        }*/
        new Consumer().run();
    }
}
