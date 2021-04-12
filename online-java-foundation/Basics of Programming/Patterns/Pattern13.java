import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        for (int row = 0; row < n; row++) {
            int toPrint = 1;
            for (int col = 0; col <= row; col++) {
                System.out.print(toPrint + "	");
                toPrint = toPrint * (row - col) / (col + 1);
            }
            System.out.println();
        }
    }
}