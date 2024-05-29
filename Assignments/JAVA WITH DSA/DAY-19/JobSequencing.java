package com.DAY_19;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Job {
    int Id;
    int Deadline;
    int Profit;

    public Job(int id, int deadline, int profit) {
        Id = id;
        Deadline = deadline;
        Profit = profit;
    }
}

public class JobSequencing {

    public static List<Job> jobSequencing(List<Job> jobs) {
        // Sort jobs by descending order of profit
        jobs.sort((a, b) -> b.Profit - a.Profit);

        // Find the maximum deadline among all jobs to create the time slots
        int maxDeadline = jobs.stream().max(Comparator.comparingInt(job -> job.Deadline)).get().Deadline;
        
        // Create an array to keep track of free time slots
        Job[] result = new Job[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        // Initialize all time slots to be free
        Arrays.fill(slot, false);

        // Iterate over the sorted jobs
        for (Job job : jobs) {
            // Find a free time slot for this job (starting from the last possible slot)
            for (int j = Math.min(maxDeadline - 1, job.Deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    // Assign the job to this free slot
                    result[j] = job;
                    slot[j] = true;
                    break;
                }
            }
        }

        // Collect all jobs that have been scheduled
        List<Job> jobSequence = new ArrayList<>();
        for (Job job : result) {
            if (job != null) {
                jobSequence.add(job);
            }
        }

        return jobSequence;
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        );

        List<Job> jobSequence = jobSequencing(jobs);

        System.out.println("Maximum profit sequence of jobs:");
        for (Job job : jobSequence) {
            System.out.println("Job Id: " + job.Id + ", Deadline: " + job.Deadline + ", Profit: " + job.Profit);
        }
    }
}
