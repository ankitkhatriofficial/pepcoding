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
        
        if(arr.length > 0){
            int max = arr[0];
            int min = arr[0];
            
            for(int val : arr){
                if(val > max)
                    max = val;
                if(val < min)
                    min = val;
            }   
            
            System.out.println(max - min);
        }
    }
}