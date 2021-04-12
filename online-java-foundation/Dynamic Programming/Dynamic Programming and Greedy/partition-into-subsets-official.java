import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long noOfWays = waysToPartition(n, k);
        System.out.println(noOfWays);
    }
    
    public static long waysToPartition(int n, int k){
        
        long[][] dp = new long[k + 1][n + 1];
        
        for(int i = 1; i < dp[0].length; i++){
            dp[1][i] = 1;
        }
        
        for(int i = 2; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < i)
                    dp[i][j] = 0;
                else if(j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i][j - 1] * i) + dp[i - 1][j - 1];
            }
        }
        return dp[k][n];
    }
}