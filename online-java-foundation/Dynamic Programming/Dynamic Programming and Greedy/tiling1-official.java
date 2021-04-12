import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int noOfWays = waysToTile(n);
        System.out.println(noOfWays);
    }
    
    public static int waysToTile(int n){
        if(n == 1 || n == 2){
            return n;
        }
    
        int fnm1 = 2;
        int fnm2 = 1;
        
        for(int i = 3; i < n; i++){
            int total = fnm1 + fnm2;
            fnm2 = fnm1;
            fnm1 = total;
        }
        
        return (fnm1 + fnm2);
    }
}