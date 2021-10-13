import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        int k = sc.nextInt();
        
        HashSet<Character> set = new HashSet<>();
        String uniqueStr = "";
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(set.contains(ch) == false){
                set.add(ch);
                uniqueStr += ch;
            }
        }
        
        combination2(uniqueStr, 0, k, -1, "");
    }
    
    public static void combination2(String uniqueStr, int cs, int k, int lc, String asf){
        if(cs == k){
            System.out.println(asf);
            return;
        }    
        
        for(int i = lc + 1; i < uniqueStr.length(); i++){
            char ch = uniqueStr.charAt(i);
            combination2(uniqueStr, cs + 1, k, i, asf + ch);
        }
    }

}