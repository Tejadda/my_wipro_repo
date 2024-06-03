package com.DAY_23;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create a thread-safe counter
        Counter counter = new Counter();
        
        // Create threads that increment and decrement the counter
        Thread incrementThread = new Thread(new IncrementTask(counter));
        Thread decrementThread = new Thread(new DecrementTask(counter));
        
        // Start the threads
        incrementThread.start();
        decrementThread.start();
        
        // Wait for the threads to finish
        incrementThread.join();
        decrementThread.join();
        
        // Display the final counter value
        System.out.println("Final counter value: " + counter.getValue());

        // Create and share immutable data between threads
        ImmutableData immutableData = new ImmutableData("Hello", 42);
        
        // Create threads that read the immutable data
        Thread readThread1 = new Thread(new ReadTask(immutableData));
        Thread readThread2 = new Thread(new ReadTask(immutableData));
        
        // Start the threads
        readThread1.start();
        readThread2.start();
        
        // Wait for the threads to finish
        readThread1.join();
        readThread2.join();
    }
}

// Thread-safe Counter class
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getValue() {
        return count;
    }
}

// Task to increment the counter
class IncrementTask implements Runnable {
    private final Counter counter;

    IncrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

// Task to decrement the counter
class DecrementTask implements Runnable {
    private final Counter counter;

    DecrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.decrement();
        }
    }
}

// Immutable class to share data between threads
final class ImmutableData {
    private final String message;
    private final int value;

    ImmutableData(String message, int value) {
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public int getValue() {
        return value;
    }
}

// Task to read immutable data
class ReadTask implements Runnable {
    private final ImmutableData data;

    ReadTask(ImmutableData data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Reading immutable data: " + data.getMessage() + ", " + data.getValue());
    }
}

