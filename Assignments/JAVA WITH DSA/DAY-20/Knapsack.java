package DAY_20;
public class Knapsack {

    // Function to solve the Knapsack problem
    public static int Knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        // DP table to store the maximum value for each capacity and item count
        int[][] dp = new int[n + 1][W + 1];

        // Build the table in a bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    // Max value obtained either by including or excluding the current item
                    dp[i][w] = Math.max(dp[i - 1][w],
                            dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // If the weight of the current item is more than the knapsack capacity w
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The maximum value that can be obtained with the given capacity
        return dp[n][W];
    }

    public static void main(String[] args) {
        int W = 50; // Knapsack capacity
        int[] weights = {10, 20, 30}; // Weights of items
        int[] values = {60, 100, 120}; // Values of items

        // Calculate the maximum value that can be carried in the knapsack
        int maxValue = Knapsack(W, weights, values);

        // Print the result
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
