import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
            
        int k = sc.nextInt();
    
        int maxProfit = calculateProfit(arr, k);
        System.out.println(maxProfit);
    }

    public static int calculateProfit(int[] arr, int noOfTrans){
        
        int[][] dp = new int[noOfTrans + 1][arr.length];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                
                int max = dp[i][j - 1];
                for(int k = 0; k < j; k++)
                    max = Math.max(max, (dp[i - 1][k] + arr[j] - arr[k]));
                    
                dp[i][j] = max;
            }
        }
            
        return dp[noOfTrans][arr.length - 1];
    }
}