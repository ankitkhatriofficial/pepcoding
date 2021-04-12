import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }
        
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }
        
        int[] diff = difference(arr1, arr2);
        int idx = 0;
        while(idx < diff.length - 1){
            if(diff[idx] == 0){
                idx++;
            }else{
                break;
            }
        }
        
        for(; idx < diff.length; idx++){
            System.out.println(diff[idx]);
        }
    }
    
    public static int[] difference(int[] arr1, int[] arr2){
        int[] diff = new int[arr2.length];
        
        int carry = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diff.length - 1;
        
        while(k >= 0){
            int aval = i >= 0 ? arr1[i] : 0;
            if(arr2[j] + carry >= aval){
                diff[k] = arr2[j] + carry - aval;
                carry = 0;
            }else{
                diff[k] = arr2[j] + carry + 10 - aval;
                carry = -1;
            }
            i--;
            j--;
            k--;
        }
        return diff;
    }
}