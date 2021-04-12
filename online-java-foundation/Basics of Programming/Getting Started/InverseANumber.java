import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int inverse = 0;
        int opos = 1;
        while (num > 0) {
            int odigit = num % 10;
            int pow = 1;
            for (int i = 0; i < odigit - 1; i++) {
                pow *= 10;
            }
            inverse = (opos * pow) + inverse;
            opos++;
            num /= 10;
        }

        System.out.println(inverse);
    }
}