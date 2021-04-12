import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

       int n = scn.nextInt();
       
       int spaces = 0;
       for(int row = 1; row <= n; row++){
           
            for(int space = 1; space <= spaces; space++)
                System.out.print("	");
            
            System.out.print("*");
            
            spaces++;
            System.out.println();
       }

    }
}