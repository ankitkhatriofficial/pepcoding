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
    
        int[] dpl = new int[arr.length];
        int minPriceOnLeft = arr[0];
       
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < minPriceOnLeft)
                minPriceOnLeft = arr[i];
            
            int profit = arr[i] - minPriceOnLeft;
            dpl[i] = Math.max(dpl[i - 1], profit);;
        }
        
        int[] dpr = new int[arr.length];
        int maxPriceOnRight = arr[arr.length - 1];
        
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] > maxPriceOnRight)
                maxPriceOnRight = arr[i];
            
            int profit = maxPriceOnRight - arr[i];
            dpr[i] = Math.max(dpr[i + 1], profit);
        }
        
        int maxProfit = 0;
        for(int i = 0; i < arr.length; i++){
            if(dpl[i] + dpr[i] > maxProfit)
                maxProfit = dpl[i] + dpr[i];
        }
        
        return maxProfit;
    }
}