import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        
        int maxProfit = calculateProfit(arr);
        System.out.println(maxProfit);
    }
    
    public static int calculateProfit(int[] arr){
        
        int costPrice = arr[0];
        
        int[] dp = new int[arr.length];

        for(int i = 0; i < dp.length; i++){
            if(arr[i] < costPrice){
                costPrice = arr[i];
                dp[i] = 0;
            }else{
                dp[i] = arr[i] - costPrice;
            }
        }
    
        int maxProfit = dp[0];
        for(int i = 1; i < dp.length; i++){
            if(dp[i] > maxProfit)
                maxProfit = dp[i];
        }
        
        return maxProfit;
    }
}