import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            map.put(arr[i], true);
        }
        
        for(Integer key : map.keySet()){
            if(map.containsKey(key - 1))
                map.put(key, false);
        }
    
        int start_seq = 0;
        int length = 0;
    
        for(Integer key : map.keySet()){
            if(map.get(key) == true){
                int count = 1;
                while(map.containsKey(key + count))
                    count++;
                if(count > length){
                    length = count;
                    start_seq = key;
                }
            }
        }
        
        for(int i = start_seq; i < (start_seq + length); i++)
            System.out.println(i);
    }

}