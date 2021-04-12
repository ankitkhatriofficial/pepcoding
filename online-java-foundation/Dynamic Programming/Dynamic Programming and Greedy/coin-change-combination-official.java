import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rupees = new int[n];
        for(int i = 0; i < n; i++){
            rupees[i] = sc.nextInt();
        }
        
        int amt = sc.nextInt();
        int combination = waysOfPayingAmount(rupees, amt);
        System.out.println(combination);
    }
    
    public static int waysOfPayingAmount(int[] rupees, int amt){
        
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        
        for(int i = 0; i < rupees.length; i++){
            for(int j = rupees[i]; j < dp.length; j++){
                if(dp[j - rupees[i]] > 0){
                    dp[j] = dp[j] + dp[j - rupees[i]];
                }
            }
        }
        return dp[dp.length - 1];
    }
}