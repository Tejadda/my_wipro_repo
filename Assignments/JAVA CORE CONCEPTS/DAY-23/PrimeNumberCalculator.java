package com.DAY_23;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrimeNumberCalculator {

    // Function to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Task to calculate prime numbers up to a given limit
    static class PrimeTask implements Callable<List<Integer>> {
        private final int start;
        private final int end;

        PrimeTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() {
            List<Integer> primes = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
            return primes;
        }
    }

    // Function to write primes to a file asynchronously using CompletableFuture
    public static CompletableFuture<Void> writePrimesToFile(List<Integer> primes, String filename) {
        return CompletableFuture.runAsync(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (int prime : primes) {
                    writer.write(prime + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        int limit = 100000;
        int numWorkers = 10;

        ExecutorService executor = Executors.newFixedThreadPool(numWorkers);
        List<Future<List<Integer>>> futures = new ArrayList<>();

        // Divide the task into parts and submit to the executor
        int chunkSize = limit / numWorkers;
        for (int i = 0; i < numWorkers; i++) {
            int start = i * chunkSize + 1;
            int end = (i == numWorkers - 1) ? limit : start + chunkSize - 1;
            PrimeTask task = new PrimeTask(start, end);
            futures.add(executor.submit(task));
        }

        // Collect the results from the futures
        List<Integer> allPrimes = new ArrayList<>();
        for (Future<List<Integer>> future : futures) {
            try {
                allPrimes.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Write the results to a file asynchronously
        CompletableFuture<Void> fileWriteFuture = writePrimesToFile(allPrimes, "primes.txt");
        fileWriteFuture.join(); // Wait for the file write to complete

        // Shutdown the executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks completed and primes written to file.");
    }
}
