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
        
        int obsp = arr[0];
        int ossp = 0;
        int ocsp = 0;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - ocsp < obsp)
                obsp = arr[i] - ocsp;
                
            ocsp = ossp;
            
            if(arr[i] - obsp > ossp)
                ossp = arr[i] - obsp;
        }
        return ossp;
    }
}