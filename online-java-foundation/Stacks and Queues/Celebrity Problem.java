import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }
        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] persons) {
    
        Stack<Integer> st = new Stack<>(); 
        
        for(int person = 0; person < persons.length; person++)
            st.push(person);
            
        while(st.size() >= 2){
            int person1 = st.pop();
            int person2 = st.pop();
            
            if(persons[person1][person2] == 1)
                st.push(person2);
            else
                st.push(person1);
        }
        
        int celebrity = st.pop();
        for(int person = 0; person < persons.length; person++){
            if(person != celebrity && (persons[person][celebrity] == 0 || persons[celebrity][person] == 1)){
                System.out.println("none");
                return;
            }
        }
        
        System.out.println(celebrity);
    }
}