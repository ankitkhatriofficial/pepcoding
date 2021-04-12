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
        
        int[] sum = getSum(arr1, arr2);
        if(sum[0] != 0){
            System.out.println(sum[0]);
        }
        
        for(int i = 1; i < sum.length; i++){
            System.out.println(sum[i]);
        }
    }

    public static int[] getSum(int[] a, int[] b){
        int[] result = new int[(a.length > b.length ? a.length : b.length) + 1];
        
        int i = a.length - 1;
        int j = b.length - 1;
        int k = result.length - 1;
        int carry = 0;
        
        while(k > 0){
            int sum = carry;
            if(i >= 0){
                sum += a[i];
            }
            if(j >= 0){
                sum += b[j];
            }
            carry = sum / 10;
            result[k] = sum % 10;
            
            i--;
            j--;
            k--;
        }
        result[0] = carry;
        return result;
    }
}