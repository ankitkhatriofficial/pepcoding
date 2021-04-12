import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        System.out.println(getMazePaths(1, 1, dr, dc));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }else if(sr > dr || sc > dc){
            return new ArrayList<>();
        }
        
        ArrayList<String> phres = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> pcres = getMazePaths(sr + 1, sc, dr, dc);
        
        ArrayList<String> res = new ArrayList<>();
        for(String ele : phres){
            res.add("h" + ele);
        }
        for(String ele : pcres){
            res.add("v" + ele);
        }
        return res;
    }
}