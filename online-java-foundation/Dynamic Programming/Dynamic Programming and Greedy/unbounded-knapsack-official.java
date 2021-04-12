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
            int maxValue = solve(weights, values, bag);
            System.out.println(maxValue);
	    }
	    
	    public static int solve(int[] weights, int[] values, int bag){
	        
	        int[] dp = new int[bag + 1];
	        dp[0] = 0;
	        
	        for(int i = 1; i < dp.length; i++){
	            for(int j = 0; j < weights.length; j++){
	                if(i >= weights[j]){
	                    int sum = dp[i - weights[j]] + values[j];
	                    dp[i] = Math.max(sum, dp[i]);
	                }
	            }
	        }
	        
	        return dp[dp.length - 1];
	    }
	}