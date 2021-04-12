import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] dp = new int[n + 1];
        int paths = stairPaths(n, dp);
        System.out.println(paths);
    }

    public static int stairPaths(int n, int[] dp){
        if(n < 0){
            return 0;
        }else if(n == 0){
            return 1;
        }else if(dp[n] > 0){
            return dp[n];
        }
        
        int pathsNm1 = stairPaths(n - 1, dp);
        int pathsNm2 = stairPaths(n - 2, dp);
        int pathsNm3 = stairPaths(n - 3, dp);
        
        dp[n] = pathsNm1 + pathsNm2 + pathsNm3;
        return dp[n];
    } 
}