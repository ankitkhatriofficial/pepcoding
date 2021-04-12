import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

/*  // Iterative Approach
    public static void rotate(int[] a, int k) {

        if (k % a.length == 0) {
            return;
        }

        k = k % a.length;
        if (k < 0)
            k = k + a.length;

        int[] temp = new int[a.length - k];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = a[i];
        }

        int starter = 0;
        for (int i = a.length - k; i < a.length; i++) {
            a[starter] = a[i];
            starter++;
        }

        for (int i = 0; i < temp.length; i++) {
            a[starter] = temp[i];
            starter++;
        }

    }
*/

    public static void rotate(int[] a, int k) {
        k = k % a.length;
        if(k < 0)
            k = k + a.length;
      
        reverse(a, 0, a.length - k - 1);
        reverse(a, a.length - k, a.length - 1);
        reverse(a, 0, a.length - 1);
    }
    
    public static void reverse(int[] a, int i, int j){
        while(i < j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            
            i++;
            j--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }

}