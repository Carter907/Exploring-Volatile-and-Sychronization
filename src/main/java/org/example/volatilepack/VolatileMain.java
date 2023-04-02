package org.example.volatilepack;

class MyRunnable implements Runnable {

    public VolatileData data;

    public MyRunnable(VolatileData data) {
        this.data = data;
    }

    public void run() {
        while (data.getStringLength() < 100000) {

            System.out.println(Thread.currentThread().getName() + ": " + data.getStringLength());
            data.increaseString();
        }
    }

}

public class VolatileMain {
    public static void main(String[] args) {

        final VolatileData data = new VolatileData();

        MyRunnable a = new MyRunnable(data);
        MyRunnable b = new MyRunnable(data);


        Thread t1 = new Thread(a, "Thread 1");
        Thread t2 = new Thread(b, "Thread 2");
        Thread checker = new Thread(() -> {
            while (a.data.getStringLength() < 100000) {


                if (!a.data.equals(b.data)) {
                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        System.err.println("""
                                    
                                RACE CONDITION:
                                
                                    Data from Runnable a did not match
                                    up with data running in Runnable b
                                    
                                """

                        );
                    }));
                    System.exit(1);
                } else {
                    System.out.println(a.data.getStringLength() + " equals " + b.data.getStringLength());
                }
            }
        }, "Checker Thread");

        t1.start();
        t2.start();

        checker.start();


    }
}