import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
        }
        
        int k = Integer.parseInt(br.readLine());
    
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < arr.length; i++){
            if(i < k + 1)
                pq.add(arr[i]);
            else{
                int val = pq.remove();
                System.out.println(val);
                pq.add(arr[i]);
            }
        }
    
        while(pq.size() > 0)
            System.out.println(pq.remove());
    }

}