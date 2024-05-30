package com.DAY_21;
public class KnightsTour {
    private static final int N = 8; // Chessboard size
    
    // These arrays are used to get the next move of the knight
    private static final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
    
    // Utility function to check if the move is valid
    private static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }
    
    // Function to print the solution
    private static void printSolution(int[][] board) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
    }
    
    // Main function to solve the Knight's Tour problem using backtracking
    public static boolean solveKnightsTour(int[][] board, int moveX, int moveY, int moveCount, int[] xMove, int[] yMove) {
        int nextX, nextY;
        if (moveCount == N * N) {
            return true;
        }
        
        for (int k = 0; k < 8; k++) {
            nextX = moveX + xMove[k];
            nextY = moveY + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightsTour(board, nextX, nextY, moveCount + 1, xMove, yMove)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1; // Backtracking
                }
            }
        }
        
        return false;
    }
    
    // Function to initialize the board and start the tour
    public static boolean solve() {
        int[][] board = new int[N][N];
        
        // Initialization of the chessboard
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                board[x][y] = -1;
            }
        }
        
        // Starting position
        int startX = 0;
        int startY = 0;
        board[startX][startY] = 0; // Start from the first block
        
        if (!solveKnightsTour(board, startX, startY, 1, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(board);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        solve();
    }
}
