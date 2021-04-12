import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        int res = fibonnaci(n, dp);
        System.out.println(res);
    }
     
    public static int fibonnaci(int n, int[] dp){
        if(n <= 1){
            return n;
        }
        /* Checking the result in dp */
        else if(dp[n] > 0){
            return dp[n];
        }
        
        int fnm1 = fibonnaci(n - 1, dp);
        int fnm2 = fibonnaci(n - 2, dp);
        
        /* storing the result in dp */
        dp[n] = fnm1 + fnm2;
        return dp[n];
    }
}