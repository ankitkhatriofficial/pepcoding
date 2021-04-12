import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int a = n1, b = n2;
        while (a % b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }

        int gcd = b;
        int lcm = (n1 * n2) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}