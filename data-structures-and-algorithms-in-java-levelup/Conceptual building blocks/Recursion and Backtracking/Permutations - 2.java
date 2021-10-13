import java.io.*;
import java.util.*;

public class Main {

    public static void permutations(int cb, int tb, boolean[] itemUsed, int ssf, int items, String asf){
        if(cb > tb){
            if(ssf == items)
                System.out.println(asf);
            return;
        }
        
        for(int i = 0; i < items; i++){
            if(itemUsed[i] ==  false){
                itemUsed[i] = true;
                permutations(cb + 1, tb, itemUsed, ssf + 1, items, asf + (i + 1));
                itemUsed[i] = false;
            }    
        }
        
        permutations(cb + 1, tb, itemUsed, ssf, items, asf + "0");
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(1, nboxes, new boolean[ritems], 0, ritems, "");
    }

}