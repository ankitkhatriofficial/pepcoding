import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        boolean result = containsExtraBracket(exp);
        System.out.println(result);
    }

    public static boolean containsExtraBracket(String exp){
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < exp.length(); i++){
            
            char ch = exp.charAt(i);
            
            if(ch == ')'){
                if(st.peek() == '(')
                    return true;
                while(st.peek() != '(')
                    st.pop();
                st.pop();                    
            }else
                st.push(ch);
        }
        
        return false;
    }
}