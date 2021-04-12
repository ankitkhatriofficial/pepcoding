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
        
        int buyDate = arr[0];
        int sellDate = arr[0];
        int profit = 0;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > sellDate){
                sellDate = arr[i];
            }else{
                profit = profit + (sellDate - buyDate);
                buyDate = sellDate = arr[i];
            }
        }
        return (sellDate > buyDate ? profit + (sellDate - buyDate) : profit);
    }
}