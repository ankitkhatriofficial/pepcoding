import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String que, String asf) {
        
        if(que.length() == 0){
            System.out.println(asf);
            return;
        }else if(que.length() == 1){
            char ch = que.charAt(0);
            if(ch == '0'){
                return;
            }else{
                int chVal = ch - '0';
                char code = (char)('a' + chVal - 1);
                System.out.println(asf + code);
                return;
            }
        }else{
            char ch = que.charAt(0);
            String roq = que.substring(1);
            if(ch == '0'){
                return;
            }else{
                int chVal = ch - '0';
                char code = (char)('a' + chVal - 1);
                printEncodings(roq, asf + code);
            }
            
            String ch2 = que.substring(0, 2);
            String roq2 = que.substring(2);
            
            int val = Integer.parseInt(ch2);
            if(val <= 26){
                char code = (char)('a' + val - 1);
                printEncodings(roq2, asf + code);
            }
        }
    }
}