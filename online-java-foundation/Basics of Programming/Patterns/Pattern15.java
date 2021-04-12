import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int spaces = n / 2;
        int stars = 1;
        int val = 1;
        
        for(int row = 1; row <= n; row++){
            
            for(int space = 1; space <= spaces; space++){
                System.out.print("	");    
            }
            
            int valToPrint = val;
            for(int star = 1; star <= stars; star++){
                System.out.print(valToPrint + "	");
                
                if(star <= stars/2){
                    valToPrint++;
                }else{
                    valToPrint--;
                }
            }
            
            if(row <= n / 2){
                spaces = spaces - 1;
                stars = stars + 2;
                val++;
            }else{
                spaces = spaces + 1;
                stars = stars - 2;
                val--;
            }
            System.out.println();
        }
    }
}