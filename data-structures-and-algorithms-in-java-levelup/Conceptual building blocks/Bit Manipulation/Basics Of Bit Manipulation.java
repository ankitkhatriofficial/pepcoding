import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();
        
        
        int setmask = (1 << i);
        int unsetmask = ~(1 << j);
        int togglemask = (1 << k);
        int checkmask = (1 << m);
        
        System.out.println(n | setmask);
        System.out.println(n & unsetmask);
        System.out.println(n ^ togglemask);
        System.out.println((n & checkmask) == 0 ? false : true);
        
    }
}