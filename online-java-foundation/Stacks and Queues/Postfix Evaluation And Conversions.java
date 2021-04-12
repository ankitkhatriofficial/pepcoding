import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        
        String[] res = solve(exp);
        for(String val : res)
            System.out.println(val);
    }
    
    public static String[] solve(String exp){
        
        Stack<Integer> result = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        
        for(int i = 0; i < exp.length(); i++){
            
            char ch = exp.charAt(i);
            
            if(Character.isDigit(ch)){
                result.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            }else{
                String second = infix.pop();
                String first = infix.pop();
                String res = '(' + first + ch + second + ')';
                infix.push(res);
             
                second = prefix.pop();
                first = prefix.pop();
                res = ch + first + second;
                prefix.push(res);   
                
                int b = result.pop();
                int a = result.pop();
                int ans = calculate(a, b, ch);
                result.push(ans);
            }
        }
        return new String[]{result.peek() + "", infix.peek(), prefix.peek()};
    }
    
    public static int calculate(int a, int b, char ch){
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