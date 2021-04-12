import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = validBinaryString(n);
        System.out.println(count);
    }
    
    public static int validBinaryString(int n){
        int stringEndsWith0 = 1;
        int stringEndsWith1 = 1;
        
        for(int i = 2; i <= n; i++){
            int newStringEndsWith1 = stringEndsWith1 + stringEndsWith0;
            int newStringEndsWith0 = stringEndsWith1;
            stringEndsWith0 = newStringEndsWith0;
            stringEndsWith1 = newStringEndsWith1;
        }
        return (stringEndsWith0 + stringEndsWith1);
    }
}