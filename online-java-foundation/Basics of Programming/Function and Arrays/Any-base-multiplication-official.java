import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2) {
        
        int result = 0;
        int pow = 1;
        
        while(n2 > 0){
            int rem = n2 % 10;
            int sprd = productWithSingleDigit(b, n1, rem);
            result = getSum(b, result, sprd * pow);
            n2 = n2 /10;
            pow = pow * 10;
        }
        return result;
    }
    
    public static int productWithSingleDigit(int b, int n1, int n2){
        int result = 0;
        int carry = 0;
        int pow = 1;
        
        while(n1 > 0 || carry > 0){
            int rem = n1 % 10;
            
            int prd = rem * n2 + carry;
            carry = prd / b;
            result += (prd % b) * pow;
            
            n1 = n1 / 10;
            pow = pow * 10;
        }
        return result;
    }
    
    public static int getSum(int b, int n1, int n2) {
        int carry = 0;
        int pow = 1;
        int sum = 0;
        
        while(n1 > 0 || n2 > 0 || carry > 0){
            int rem1 = n1 % 10;
            int rem2 = n2 % 10;
            int add = rem1 + rem2 + carry;
            
            carry = add / b;
            sum = sum + (add % b * pow);
            
            n1 = n1 / 10;
            n2 = n2 / 10;
            pow = pow * 10;
        }
        return sum;
    }
}