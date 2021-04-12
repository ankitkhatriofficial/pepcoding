import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int maxSum = maximumSum(arr);
        System.out.println(maxSum);
    }

    public static int maximumSum(int[] arr){
        
        int include = arr[0];
        int exclude = 0;
        
        for(int i = 1; i < arr.length; i++){
            int newInclude = exclude + arr[i];
            int newExclude = Math.max(include, exclude);
            
            include = newInclude;
            exclude = newExclude;
        }
        
        return Math.max(include, exclude);
    }
}