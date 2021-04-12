import java.io.*;
import java.util.*;

public class Main{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        
        int result = solve(exp);
        System.out.println(result);
    }
    
    public static int solve(String exp){
        
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        
        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            
            if(Character.isDigit(ch))
                operand.push(ch - '0');
            else if(ch == '(')
                operator.push(ch);
            else if(ch == ')'){
                while(operator.peek() != '('){
                    int b = operand.pop();
                    int a = operand.pop();
                    char op = operator.pop();
                    int result = calculate(a, b, op);
                    operand.push(result);
                }
                operator.pop();
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operator.size() > 0 && precedence(ch) <= precedence(operator.peek()) && operator.peek() != '('){
                    int b = operand.pop();
                    int a = operand.pop();
                    char op = operator.pop();
                    int result = calculate(a, b, op);
                    operand.push(result);
                }
                operator.push(ch);
            }
        }
        while(operator.size() > 0){
            int b = operand.pop();
            int a = operand.pop();
            char op = operator.pop();
            int result = calculate(a, b, op);
            operand.push(result);
        }
        return operand.peek();
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
                return -1;
        }
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