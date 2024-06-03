/*Creating and Managing Threads
Write a program that starts two threads, where each thread prints numbers from 1 to 10 with a 1-second delay between each number in java*/
package com.DAY_23;

public class TwoThreads {
    public static void main(String[] args) {
        // Create the first thread
        Thread thread1 = new Thread(new NumberPrinter(), "Thread 1");
        // Create the second thread
        Thread thread2 = new Thread(new NumberPrinter(), "Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();
    }
}

class NumberPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                // Sleep for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle the exception
                System.err.println("Thread was interrupted");
            }
        }
    }
}
