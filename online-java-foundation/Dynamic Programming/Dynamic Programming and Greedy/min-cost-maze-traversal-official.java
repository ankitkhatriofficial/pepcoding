import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] maze = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        
        int rupees = minCost(maze);
        System.out.println(rupees);
    }

    private static int minCost(int[][] maze){
        
        int row = maze.length;
        int col = maze[0].length;
        
        int[][] dp = new int[row][col];
        /* copy the last price of maze (dest) to dp */
        dp[row - 1][col - 1] = maze[row - 1][col - 1];
        
        /* filling the last row of dp */
        for(int i = row - 1, j = col - 2; j >= 0; j--){
            dp[i][j] = maze[i][j] + dp[i][j + 1];
        }
        
        /* filling the last column of dp */
        for(int i = row - 2, j = col - 1; i >= 0; i--){
            dp[i][j] = maze[i][j] + dp[i + 1][j];
        }
        
        for(int i = row - 2; i >= 0; i--){
            for(int j = col - 2; j >= 0; j--){
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = maze[i][j] + min;
            }
        }
        
        return dp[0][0];
    }
}