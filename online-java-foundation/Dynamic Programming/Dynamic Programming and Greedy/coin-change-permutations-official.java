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
        int amt = sc.nextInt();
        int permutation = waysOfPayingAmount(arr, amt);
        System.out.println(permutation);
    }
    
    public static int waysOfPayingAmount(int[] rupees, int amt){
        
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < rupees.length; j++){
                if(i >= rupees[j]){
                    dp[i] = dp[i] + dp[i - rupees[j]];
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}