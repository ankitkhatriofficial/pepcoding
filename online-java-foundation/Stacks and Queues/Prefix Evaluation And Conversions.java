import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        
        String[] res = solve(exp);
        for(String val : res)
            System.out.println(val);
    }
    
    public static String[] solve(String exp){
        Stack<Integer> result = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        
        for(int i = exp.length() - 1; i >= 0; i--){
            char ch = exp.charAt(i);
            
            if(Character.isDigit(ch)){
                result.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");
            }else{
                String first = infix.pop();
                String second = infix.pop();
                String res = '(' + first + ch + second + ')';
                infix.push(res);
                
                first = postfix.pop();
                second = postfix.pop();
                res = first + second + ch;
                postfix.push(res);
                
                int a = result.pop();
                int b = result.pop();
                int ans = calculate(a, b, ch);
                result.push(ans);
            }
        }
        
        return new String[]{result.peek() + "", infix.peek(), postfix.peek()};
    }
    
    private static int calculate(int a, int b, char ch){
        switch(ch){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }
}