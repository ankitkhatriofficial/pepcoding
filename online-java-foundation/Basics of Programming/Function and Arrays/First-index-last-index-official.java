import java.io.*;
import java.util.*;

public class Main {

    public static void printFirstAndLastIndex(int[] arr, int data){
        
        int low = 0;
        int high = arr.length - 1;
        int lIdx = -1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > data){
                high = mid - 1;
            }else if(arr[mid] < data){
                low = mid + 1;
            }else{
                lIdx = mid;
                high = mid - 1;
            }
        }
        System.out.println(lIdx);

        low = 0;
        high = arr.length - 1;
        int rIdx = -1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > data){
                high = mid - 1;
            }else if(arr[mid] < data){
                low = mid + 1;
            }else{
                rIdx = mid;
                low = mid + 1;
            }
        }
        System.out.println(rIdx);
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        int d = sc.nextInt();
        printFirstAndLastIndex(arr, d);
    }
}