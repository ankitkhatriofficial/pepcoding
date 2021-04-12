import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int spaces = 2 * n - 3;
        int stars = 1;

        for (int row = 1; row <= n; row++) {
            int val = 1;
            for (int star = 1; star <= stars; star++) {
                System.out.print(val + "	");
                val++;
            }

            for (int space = 1; space <= spaces; space++) {
                System.out.print("	");
            }

            if (row == n) {
                stars--;
                val--;
            }

            for (int star = 1; star <= stars; star++) {
                val--;
                System.out.print(val + "	");
            }

            stars++;
            spaces -= 2;

            System.out.println();
        }

    }
}