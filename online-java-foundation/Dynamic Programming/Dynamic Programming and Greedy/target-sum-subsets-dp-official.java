import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
            
        int tar = sc.nextInt();
        boolean res = isSubsetPresent(arr, tar);
        System.out.println(res);
    }
    
    public static boolean isSubsetPresent(int[] arr, int target){
        
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        
        /* filling first column of dp */
        dp[0][0] = true;
        for(int i = 1, j = 0; i < dp.length; i++){
            dp[i][j] = true;
        }
        
        /* filling first row */
        for(int i = 0, j = 1; j < dp[0].length; j++){
            dp[i][j] = false;
        }
        
        /* filling second row of dp */
        for(int i = 1, j = 1; j < dp[0].length; j++){
            if(j == arr[i - 1]){
                dp[i][j] = true;
            }
        }
        
        /* filling the rest cells of the dp */
        for(int i = 2; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                /* If already found a subset, then it will also be a subset */
                if(dp[i - 1][j] == true){
                    dp[i][j] = true;
                }else{
                    /* If not found subset already, then check; if it could be a subset */
                    if(j >= arr[i -1] && dp[i - 1][j - arr[i - 1]] == true){
                        dp[i][j] = true;
                    }
                }
            }
            
            /* checking fot the target subset after completion of each row */
            if(dp[i][dp[0].length - 1] == true){
                return true;
            }
        }

        /* return the last cell of dp */
        return dp[dp.length - 1][dp[0].length - 1];
    }
}