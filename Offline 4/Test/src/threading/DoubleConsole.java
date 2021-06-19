package threading;

import java.util.Scanner;

// Java code for thread creation by implementing
// the Runnable Interface
class ConsoleOne implements Runnable {
    public void run()
    {
        try {
            // Displaying the thread that is running

            System.out.println(Thread.currentThread().getId());

            Scanner sc= new Scanner(System.in);
            String msg = sc.next();
            System.out.println("Thread " + Thread.currentThread().getId() + " ---> " + msg);
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}




public class DoubleConsole {

    public static void main(String[] args) {
        Thread object1 = new Thread(new ConsoleOne());
        Thread object2 = new Thread(new ConsoleOne());

        object1.start();
        object2.start();
    }

}
