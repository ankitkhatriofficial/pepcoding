import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n1 = sc.nextInt();
        for(int i = 0; i < n1; i++){
            int val = sc.nextInt();
            if(map.containsKey(val) == true)
                map.put(val, map.get(val) + 1);
            else
                map.put(val, 1);
        }
        
        int n2 = sc.nextInt();
        for(int i = 0; i < n2; i++){
            int val = sc.nextInt();
            if(map.containsKey(val) == true && map.get(val) > 0){
                System.out.println(val);
                map.put(val, map.get(val) - 1);
            }
        }
    }
}