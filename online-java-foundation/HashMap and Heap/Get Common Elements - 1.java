import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        HashSet<Integer> set = new HashSet<>();
        
        int n1 = sc.nextInt();
        for(int i = 0; i < n1; i++)
            set.add(sc.nextInt());
            
        int n2 = sc.nextInt();
        for(int i = 0; i < n2; i++){
            int val = sc.nextInt();
            if(set.contains(val) == true){
                set.remove(val);
                System.out.println(val);
            }
        }
    }
}