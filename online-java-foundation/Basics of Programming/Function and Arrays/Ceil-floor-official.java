import java.io.*;
import java.util.*;

public class Main {
    
    public static void printCeilAndFloor(int[] arr, int data){
        
        int low = 0;
        int high = arr.length - 1;
        int ceil = 0, floor = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > data){
                ceil = arr[mid];
                high = mid - 1;
            }else if(arr[mid] < data){
                floor = arr[mid];
                low = mid + 1;
            }else{
                floor = arr[mid];
                ceil = arr[mid];
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        int d = sc.nextInt();
        printCeilAndFloor(arr, d);
    }
}