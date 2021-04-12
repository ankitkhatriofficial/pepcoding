import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int spaces = 1;
        int stars =  n / 2;
        
        for(int row = 1; row <= n; row++){
            
            System.out.print("*	");
            
            for(int star = 1; star <= stars; star++){
                System.out.print("*	");
            }
            for(int space = 1; space <= spaces; space++){
                System.out.print("	");
            }
            for(int star = 1; star <= stars; star++){
                System.out.print("*	");
            }
            
            if(row <= n / 2){
                spaces = spaces + 2;
                stars = stars - 1;
            }else{
                spaces = spaces - 2;
                stars = stars + 1;
            }
            System.out.print("*	");
            
            System.out.println();
        }

    }
}