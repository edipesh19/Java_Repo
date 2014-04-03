package com.threads;
public class WaitNotifyExample {
 
    private Object lock = new Object();
 
    public WaitNotifyExample() {
 
    }
 
    public void runLongTask() {
 
        Thread job = new Thread(new Runnable() {
 
            public void run() {
 
                System.out.println("Long task started");
 
                try {
 
                    int maxCount = 1000;
                    // int maxCount = Integer.MAX_VALUE;
 
                    // do some long task
                    for (int i = 0; i < maxCount; i++) {
                        System.out.println(i);
                        try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
                    }
 
                    System.out.println("Long task done.");
 
                } finally {
 
                    System.out.println("About to notify lock...");
 
                    synchronized (lock) {
                        lock.notifyAll();
                    }
 
                    System.out.println("Lock notified");
 
                }
 
            }
        });
 
        // job.setPriority(Thread.MAX_PRIORITY - 2);
 
        System.out.println("Starting a long task...");
        job.start();
 
        System.out.println("Pausing normal execution and waiting for long task to finish...");
 
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
 
        System.out.println("Resuming normal execution as long task is done.");
 
    }
 
    public static void main(String[] a) {
 
        new WaitNotifyExample().runLongTask();
 
    }
 
}