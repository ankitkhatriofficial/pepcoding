import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    public static int getValueIndecimal(int n, int b) {
        
        int pow = 1;
        int decimalVal = 0;
        
        while(n > 0){
            int rem = n % 10;
            decimalVal += rem * pow;
            pow = pow * b;
            n = n / 10;
        }
        return decimalVal;
    }
}