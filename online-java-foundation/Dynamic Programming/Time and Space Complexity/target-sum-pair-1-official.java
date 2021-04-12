import java.io.*;
import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target){
    Arrays.sort(arr);
    
    int low = 0, high = arr.length - 1;
    while(low < high){
        if(arr[low] + arr[high] < target){
            low++;
        }else if(arr[low] + arr[high] > target){
            high--;
        }else{
            System.out.println(arr[low] + ", " + arr[high]);
            low++;
            high--;
        }
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}