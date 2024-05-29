package com.DAY_19;
import java.util.Arrays;

public class TravelingSalesman {

    public static int FindMinCost(int[][] graph) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1;
        int[][] dp = new int[n][(1 << n)];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return tsp(0, 1, dp, graph, VISITED_ALL);
    }

    private static int tsp(int current, int mask, int[][] dp, int[][] graph, int VISITED_ALL) {
        if (mask == VISITED_ALL) {
            return graph[current][0];
        }

        if (dp[current][mask] != -1) {
            return dp[current][mask];
        }

        int minCost = Integer.MAX_VALUE;

        for (int city = 0; city < graph.length; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = graph[current][city] + tsp(city, mask | (1 << city), dp, graph, VISITED_ALL);
                minCost = Math.min(minCost, newCost);
            }
        }

        dp[current][mask] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("The minimum cost to visit all cities and return to the starting city is: " + FindMinCost(graph));
    }
}
