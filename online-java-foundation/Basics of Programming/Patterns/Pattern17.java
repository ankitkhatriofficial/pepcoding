import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int stars = 1;
        int spaces = n / 2;
        for(int row = 1; row <= n; row++){
            
            for(int space = 1; space <= spaces; space++){
                if(row == n/2 + 1){
                    System.out.print("*	");
                }else{
                    System.out.print("	");
                }
            }
            
            for(int star = 1; star <= stars; star++){
                System.out.print("*	");
            }
            
            if(row <= n/2){
                stars++;
            }else{
                stars--;
            }
            System.out.println();
        }
        
    }
}