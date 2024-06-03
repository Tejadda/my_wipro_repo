package com.DAY_23;
import java.util.concurrent.*;
import java.util.*;

public class ThreadPoolExample {

    // Define a task that performs a complex calculation
    static class ComplexCalculationTask implements Callable<Integer> {
        private final int taskId;

        ComplexCalculationTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("Task " + taskId + " starting.");
            int duration = new Random().nextInt(5) + 1; // Random duration between 1 and 5 seconds
            Thread.sleep(duration * 1000); // Simulate a long-running task
            int result = duration * 2; // Simulate some calculation
            System.out.println("Task " + taskId + " completed with result " + result + ".");
            return result;
        }
    }

    public static void main(String[] args) {
        // Create a fixed-size thread pool
        int numWorkers = 5;
        ExecutorService executor = Executors.newFixedThreadPool(numWorkers);

        // List to hold Future objects
        List<Future<Integer>> futures = new ArrayList<>();

        // Submit multiple tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            ComplexCalculationTask task = new ComplexCalculationTask(i);
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }

        // Collect and print results as they complete
        for (Future<Integer> future : futures) {
            try {
                Integer result = future.get(); // Blocking call to get the result
                System.out.println("Result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shut down the executor service
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks completed.");
    }
}

