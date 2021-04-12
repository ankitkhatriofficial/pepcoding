import java.io.*;
import java.util.*;

public class Main {
    
    static String[] codes = {".;" , "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printKPC(str, "");
    }

    public static void printKPC(String que, String ans) {
        if(que.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = que.charAt(0);
        String roq = que.substring(1);
        
        String code = codes[ch - '0'];
        for(int i = 0; i < code.length(); i++){
            char codech = code.charAt(i);
            printKPC(roq, ans + codech);
        }
    }
}