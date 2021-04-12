import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] values = new int[n];
        for(int i = 0; i < n; i++){
            values[i] = sc.nextInt();
        }
        
        int[] weights = new int[n];
        for(int i = 0; i < n; i++){
            weights[i] = sc.nextInt();
        }
        
        int bag = sc.nextInt();
        int maxVal = solve(weights, values, bag);
        System.out.println(maxVal);
    }
    
    public static int solve(int[] weights, int[] values, int bag){
        
        int[][] dp = new int[weights.length + 1][bag + 1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j >= weights[i - 1]){
                    /* updating the new result in dp */
                    int idxOfJ = j - weights[i - 1];
                    int sum = dp[i - 1][idxOfJ] + values[i - 1];
                    dp[i][j] = Math.max(sum, dp[i - 1][j]);
                }else{
                    /* copying the previous dp result */
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}