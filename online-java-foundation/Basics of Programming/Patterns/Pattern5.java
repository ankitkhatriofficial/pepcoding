import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int spaces = n / 2;
        int stars = 1;

        for (int row = 1; row <= n; row++) {

            for (int space = 1; space <= spaces; space++)
                System.out.print("	");

            for (int star = 1; star <= stars; star++)
                System.out.print("*	");

            for (int space = 1; space <= spaces; space++)
                System.out.print("	");

            /* conditions for making upper half and bottom half of the diamond */
            if (row <= n / 2) {
                spaces = spaces - 1;
                stars = stars + 2;
            } else {
                spaces = spaces + 1;
                stars = stars - 2;
            }
            System.out.println();
        }

    }
}
