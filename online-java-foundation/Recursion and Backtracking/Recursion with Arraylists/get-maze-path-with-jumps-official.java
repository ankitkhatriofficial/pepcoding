import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int dr = sc.nextInt();
        int dc = sc.nextInt();
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
        
        ArrayList<String> res = new ArrayList<>();
        //for horizontal paths
        for(int i = 1; i <= (dc - sc); i++){
            ArrayList<String> phres = getMazePaths(sr, sc + i, dr, dc);
            for(String ele : phres){
                res.add("h" + i + ele);
            }
        }
        //for vertical paths
        for(int i = 1; i <= (dr - sr); i++){
            ArrayList<String> pcres = getMazePaths(sr + i, sc, dr, dc);
            for(String ele : pcres){
                res.add("v" + i +  ele);
            }
        }
        //for diagnoal paths
        for(int i = 1; i <= (dr - sr) && i <= (dc - sc); i++){
            ArrayList<String> pdres = getMazePaths(sr + i, sc + i, dr, dc);
            for(String ele : pdres){
                res.add("d" + i + ele);
            }
        }
        return res;
    }
}