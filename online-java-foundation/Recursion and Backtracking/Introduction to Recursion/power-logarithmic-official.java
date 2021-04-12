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
        if(num <= 0){
            return 1;
        }
        if(pow % 2 == 0){
            return power(num * num, pow / 2);
        }else{
            return power(num * num , pow /2) * num;
        }
    }

}