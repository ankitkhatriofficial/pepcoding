import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int a = 0;
        int b = 1;
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= row; col++){
                System.out.print(a + "	");
                int temp = a + b;
                a = b;
                b = temp;
            }
            System.out.println();
        }
    }
}