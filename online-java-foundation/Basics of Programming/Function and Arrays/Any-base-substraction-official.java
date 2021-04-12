import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2) {
        int diff = 0;
        int pow = 1;
        int carry = 0;
        
        while(n2 > 0){
            int rem1 = n1 % 10;
            int rem2 = n2 % 10;
            
            int d = 0;
            rem2 = rem2 + carry;
            
            if(rem2 >= rem1){
                carry = 0;
                d = rem2 - rem1;
            }else{
                carry = -1;
                d = rem2 + b - rem1;
            }
            
            diff = diff + d * pow;
            
            n1 = n1 / 10;
            n2 = n2 / 10;
            pow = pow * 10;
        }
        return diff;
    }

}