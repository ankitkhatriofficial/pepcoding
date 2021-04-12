import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arrangements = totalArrangements(n);
        System.out.println(arrangements);
    }
    
    public static long totalArrangements(int n){
        long buildings = 1;
        long spaces = 1;
        for(int i = 2; i <= n; i++){
            long newSpaces = spaces + buildings;
            long newBuildings = spaces;
            buildings = newBuildings;
            spaces = newSpaces;
        }
        
        long totalOneSideArrangements = buildings + spaces;
        return totalOneSideArrangements * totalOneSideArrangements;
    }
}