import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a * a + b * b == c * c || b * b + c * c == a * a || a * a + c * c == b * b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}