package ro.tucn.generator;

import ro.tucn.consumer.Consumer;

import static ro.tucn.generator.CommandLineArguments.ADV_CLICK;

/**
 * Created by Liviu on 3/31/2017.
 */
public class Application {

    private Generator generator;

    public static void main(String[] args) {
        //String mode = new String(args[0]);

        new Producer().run();
        /*
        if (args.length > 0) {
            if (mode.equals("test")) {
                System.out.println("Entering test mode");
                new Producer().run();
                return;
            } else if (mode.equals(String.valueOf(ADV_CLICK))) {
                int SLEEP_FREQUENCY = -1;
                try {
                    new AdvClick().generate(SLEEP_FREQUENCY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        */
    }
}
