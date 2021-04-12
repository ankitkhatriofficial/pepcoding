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
        int x = sc.nextInt();
        System.out.println(lastIndex(arr, 0, x));
    }

    public static int lastIndex(int[] arr, int idx, int x){
       if(idx == arr.length){
           return -1;
       }
       int lIdx = lastIndex(arr, idx + 1, x);
       if(lIdx != -1){
           return lIdx;
       }
       return (arr[idx] == x ? idx : -1);
    }
}