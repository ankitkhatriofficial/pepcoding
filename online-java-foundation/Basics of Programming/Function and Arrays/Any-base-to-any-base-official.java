import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        
        int result = convert(n, sourceBase, destBase);
        System.out.println(result);
    }
    
    public static int convert(int n, int sBase, int dBase){
        int decimalVal = anyBaseToDecimal(n, sBase);
        int result = decimalToAnyBase(decimalVal, dBase);
        return result;
    }
    
    public static int anyBaseToDecimal(int n, int b){
        int decimalVal = 0;
        int pow = 1;
        while(n > 0){
            int rem = n % 10;
            decimalVal += rem * pow;
            pow = pow * b;
            n = n / 10;
        }
        return decimalVal;
    }
    
    public static int decimalToAnyBase(int n, int b){
        int result = 0;
        int pow = 1;
        while(n > 0){
            int rem = n % b;
            result = result + rem * pow;
            pow = pow * 10;
            n = n / b;
        }
        return result;
    }
}