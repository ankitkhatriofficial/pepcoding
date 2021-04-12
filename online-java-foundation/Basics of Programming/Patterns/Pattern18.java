import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int spaces = 0;
        int stars = n;
        for(int row = 1; row <=n; row++){
            
            for(int space = 1; space <= spaces; space++){
                System.out.print("	");
            }
            
            for(int star = 1; star <= stars; star++){
                if(row > 1 && row <= n/2 && star > 1 && star < stars)
                    System.out.print("	");
                else
                    System.out.print("*	");
            }
            
            if(row <= n / 2){
                stars = stars - 2;
                spaces = spaces + 1;
            }else{
                stars = stars + 2;
                spaces = spaces - 1;
            }
            System.out.println();
        }

    }
}