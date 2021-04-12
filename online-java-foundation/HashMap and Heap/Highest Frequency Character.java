import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        
        String str = sc.nextLine();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch) == true)
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        
        int max = Integer.MIN_VALUE;
        char ch = ' ';
        for(Character key : map.keySet()){
            if(map.get(key) > max){
                ch = key;
                max = map.get(key);
            }
        }
        
        System.out.println(ch);
    }

}