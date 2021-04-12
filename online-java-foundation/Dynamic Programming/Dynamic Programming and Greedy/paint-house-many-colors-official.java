import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] arr = new int[n][k];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int minCost = minCostToPaintHouse(arr);
        System.out.println(minCost);
    }
    
    public static int minCostToPaintHouse(int[][] arr){
        
        int[][] dp = new int[arr.length][arr[0].length];
        
        /* Copying first row from arr to dp */
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = arr[0][i];
        }
        
        /* filling rest of the cells in dp */
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                
                int minCost = Integer.MAX_VALUE;
                for(int k = 0; k < dp[0].length; k++){
                    if(k != j && dp[i - 1][k] < minCost){
                        minCost = dp[i - 1][k];
                    }
                }
                dp[i][j] = minCost + arr[i][j];
            }
        }
        
        /* finding the least cost in last row of dp */
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < dp[0].length; i++){
            if(dp[dp.length - 1][i] < minCost){
                minCost = dp[dp.length - 1][i];
            }
        }
        
        return minCost;
    }
}