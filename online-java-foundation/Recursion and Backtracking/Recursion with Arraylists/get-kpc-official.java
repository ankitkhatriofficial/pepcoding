import java.io.*;
import java.util.*;

public class Main {
    
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(getKPC(input));
    }

    public static ArrayList<String> getKPC(String str) {
        
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        char ch = str.charAt(0);
        String roq = str.substring(1);
        ArrayList<String> pres = getKPC(roq);
        
        ArrayList<String> res = new ArrayList<>();
        String code = codes[Integer.parseInt(ch + "")];
        for(int i = 0; i < code.length(); i++){
            char codech = code.charAt(i);
            for(String ele : pres)
                res.add(codech + ele);
        }
        return res;
    }
}