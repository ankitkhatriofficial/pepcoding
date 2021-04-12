import java.io.*;
import java.util.*;

public class Main{
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        
        String[] res = solve(exp);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
    
    public static String[] solve(String exp){
        
        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            
            if(ch == '(')
                operator.push(ch);
            else if(Character.isLetterOrDigit(ch)){
                postfix.push(ch + "");
                prefix.push(ch + "");
            }else if(ch == ')'){
                while(operator.peek() != '('){
                    
                    char op = operator.pop();
                    
                    String second = postfix.pop();
                    String first = postfix.pop();
                    String res = first + second + op;
                    postfix.push(res);
                    
                    second = prefix.pop();
                    first = prefix.pop();
                    res = op + first + second;
                    prefix.push(res);
                }
                operator.pop();
            }else{
                while(operator.size() > 0 && operator.peek() != '(' && precedence(ch) <= precedence(operator.peek())){
                    char op = operator.pop();
                    
                    String second = postfix.pop();
                    String first = postfix.pop();
                    String res = first + second + op;
                    postfix.push(res);
                    
                    second = prefix.pop();
                    first = prefix.pop();
                    res = op + first + second;
                    prefix.push(res);
                }
                operator.push(ch);
            }
        }
        
        while(operator.size() > 0){
            char op = operator.pop();
                    
            String second = postfix.pop();
            String first = postfix.pop();
            String res = first + second + op;
            postfix.push(res);
            
            second = prefix.pop();
            first = prefix.pop();
            res = op + first + second;
            prefix.push(res);
        }
        
        return new String[]{postfix.peek(), prefix.peek()};
    }
    
    private static int precedence(char ch){
        if(ch == '+' || ch == '-')
            return 1;
        else if(ch == '*' || ch == '/')
            return 2;
        else
            return 0;
    }
}