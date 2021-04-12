import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        
        int fee = sc.nextInt();
        
        int maxProfit = calculateProfit(arr, fee);
        System.out.println(maxProfit);
    }
    
    public static int calculateProfit(int[] arr, int fee){
    
        int obsp = arr[0];
        int ossp = 0;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - ossp < obsp)
                obsp = arr[i] - ossp;
            
            if(arr[i] - obsp - fee > ossp)
                ossp = arr[i] - obsp - fee;
        }
        return ossp;        
    }
}