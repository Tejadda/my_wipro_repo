package com.DAY_23;
public class ThreadLifecycleDemo {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread state: " + Thread.currentThread().getState() + " (RUNNABLE)");
                
                // Simulate TIMED_WAITING state using sleep()
                try {
                    System.out.println("Thread is going to sleep for 2 seconds.");
                    Thread.sleep(2000);
                    System.out.println("Thread state: " + Thread.currentThread().getState() + " (RUNNABLE)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Simulate WAITING state using wait()
                synchronized (lock) {
                    try {
                        System.out.println("Thread is waiting for lock notification.");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread state: " + Thread.currentThread().getState() + " (RUNNABLE)");
                }

                // Simulate BLOCKED state by attempting to acquire a lock held by another thread
                try {
                    synchronized (lock) {
                        System.out.println("Thread acquired the lock and will now finish execution.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Display initial state (NEW)
        System.out.println("Thread state: " + thread.getState() + " (NEW)");

        // Start the thread, transitioning to RUNNABLE
        thread.start();

        // Ensure the thread reaches the WAITING state
        try {
            Thread.sleep(1000); // Short sleep to allow the thread to start and reach the sleep state
            synchronized (lock) {
                System.out.println("Main thread acquired the lock.");
                Thread.sleep(500); // Hold the lock to ensure the other thread transitions to BLOCKED
                lock.notify(); // Notify the waiting thread
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait for the thread to complete, transitioning to TERMINATED
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display final state (TERMINATED)
        System.out.println("Thread state: " + thread.getState() + " (TERMINATED)");
    }
}
