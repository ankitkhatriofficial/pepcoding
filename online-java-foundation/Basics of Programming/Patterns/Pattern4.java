import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int spaces = 0;
        int stars = n;
        for (int row = 1; row <= n; row++) {

            for (int space = 1; space <= spaces; space++)
                System.out.print("\t");

            for (int star = 1; star <= stars; star++)
                System.out.print("*\t");

            spaces++;
            stars--;
            System.out.println();
        }
    }
}
