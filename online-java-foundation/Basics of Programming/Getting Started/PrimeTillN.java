import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low = sc.nextInt();
        int high = sc.nextInt();

        while (low <= high) {
            boolean isPrime = true;
            for (int div = 2; div * div <= low; div++) {
                if (low % div == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true) {
                System.out.println(low);
            }
            low++;
        }
    }
}