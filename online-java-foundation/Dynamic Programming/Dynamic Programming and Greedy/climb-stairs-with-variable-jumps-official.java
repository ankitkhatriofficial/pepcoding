import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int paths = stairPaths(n, arr);
        System.out.println(paths);
    }
    
    public static int stairPaths(int n, int[] arr){
        int[] dp = new int[n + 1];
        // we have 1 path from n to n
        dp[n] = 1;
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <= arr[i]; j++){
                if((i + j) < dp.length)
                    dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }
}