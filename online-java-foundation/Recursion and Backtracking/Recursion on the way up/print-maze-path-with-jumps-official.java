import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int dr = sc.nextInt();
        int dc = sc.nextInt();
        printMazePaths(1, 1, dr, dc, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    // psf - path so far
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }else if(sr > dr || sc > dc){
            return;
        }
        
        // Horizontal moves
        for(int i = 1; i <= (dc - sc); i++){
            printMazePaths(sr, sc + i, dr, dc, psf + ("h"+i));
        }
         // Vertical moves
        for(int i = 1; i <= (dr - sr); i++){
            printMazePaths(sr + i, sc, dr, dc, psf + ("v"+i));
        }
         // Diagonal moves
        for(int i = 1; i <= (dc - sc) && i <= (dr - sr); i++){
            printMazePaths(sr + i, sc + i, dr, dc, psf + ("d"+i));
        }
        
    }
}