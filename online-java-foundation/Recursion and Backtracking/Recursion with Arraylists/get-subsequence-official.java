import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
    
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        char ch = str.charAt(0);
        String roq = str.substring(1);
        ArrayList<String> pres = gss(roq);
        
        ArrayList<String> res = new ArrayList<>();
        for(String element : pres){
            res.add("" + element);
        }
        for(String element : pres){
            res.add(ch + element);
        }
        return res;
    }
}