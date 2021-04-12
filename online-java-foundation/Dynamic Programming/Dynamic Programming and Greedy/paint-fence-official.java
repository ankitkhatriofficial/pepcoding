import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int noOfWays = waysToPaintFences(n, k);
        System.out.println(noOfWays);
    }
    
    public static int waysToPaintFences(int n, int k){
        if(n <= 1){
            /* Problem is undefined */
            return 0;
        }
        
        int lastSame = k;
        int lastDiff = k * (k - 1);
        int total = lastSame + lastDiff;
        
        for(int i = 3; i <= n; i++){
            lastSame = lastDiff;
            lastDiff = total * (k - 1);
            total = lastSame + lastDiff;
        }
        return total;
    }
}