import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int ospace = n / 2;
        int ispace = -1;
        
        for(int row = 1; row <= n; row++){
            
            for(int space = 1; space <= ospace; space++){
                System.out.print("	");
            }
            
            System.out.print("*	");
            
            for(int space = 1; space <= ispace; space++){
                System.out.print("	");
            }
            
            if(row > 1 && row < n){
                System.out.print("*	");
            }
            
            if(row <= n/2){
                ospace--;
                ispace = ispace + 2;
            }else{
                ospace++;
                ispace = ispace - 2;
            }            
            
            System.out.println();
        }

    }
}