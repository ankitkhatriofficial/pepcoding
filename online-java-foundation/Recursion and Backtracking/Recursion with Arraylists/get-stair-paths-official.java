import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }else if(n < 0){
            return new ArrayList<>();
        }
        
        ArrayList<String> path1 = getStairPaths(n - 1);
        ArrayList<String> path2 = getStairPaths(n - 2);
        ArrayList<String> path3 = getStairPaths(n - 3);
        
        ArrayList<String> paths = new ArrayList<>();
        for(String ele : path1){
            paths.add(1 + ele);
        }
        for(String ele : path2){
            paths.add(2 + ele);
        }
        for(String ele : path3){
            paths.add(3 + ele);
        }
        return paths;
    }
}