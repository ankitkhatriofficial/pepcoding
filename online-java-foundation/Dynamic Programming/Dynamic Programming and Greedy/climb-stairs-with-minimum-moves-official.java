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
        
        int minMoves = minNumberOfMoves(n, arr);
        System.out.println(minMoves);
    }
    
    public static int minNumberOfMoves(int n, int[] arr){
        /* Meaning : To store mininum moves to reach dest from idx to n */
        Integer[] dp = new Integer[n + 1];
        /* No moves required to reach dest from dest */
        dp[n] = 0;
        
        for(int i = dp.length - 2; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= arr[i]; j++){
                if((i + j) < dp.length && dp[i + j] != null){
                    min = Math.min(min, dp[i + j]);
                }
            }
            if(min != Integer.MAX_VALUE){
                dp[i] = min + 1; // Moves will be mininum moves  + 1
            }
        }
        return dp[0];
        
    }
}