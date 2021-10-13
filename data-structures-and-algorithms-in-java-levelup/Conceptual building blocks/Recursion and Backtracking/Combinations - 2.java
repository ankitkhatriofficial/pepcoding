import java.io.*;
import java.util.*;

public class Main {

    public static void combinations(boolean[] boxes, int ci, int ti, int lb){
        if(ci > ti){
            for(boolean val : boxes)
                if(val == true)
                    System.out.print("i");
                else
                    System.out.print("-");
            System.out.println();
            return;
        }
        
        for(int i = lb + 1; i < boxes.length; i++){
            if(boxes[i] == false){
                boxes[i] = true;
                combinations(boxes, ci + 1, ti, i);
                boxes[i] = false;
            }
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(new boolean[nboxes], 1, ritems, -1);
    }

}