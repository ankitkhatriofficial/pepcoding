import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int pow = sc.nextInt();
        System.out.println(power(num, pow));
    }

    public static int power(int num, int pow){
        if(pow == 0){
            return 1;
        }
        int powerm1 = power(num, pow - 1);
        return powerm1 * num;
    }
}