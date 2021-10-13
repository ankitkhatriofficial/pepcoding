import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        int k = sc.nextInt();
        
        HashSet<Character> set = new HashSet<>();
        String uniqueStr = "";
        
        for(int i = 0; i < str.length(); i++){
            if(set.contains(str.charAt(i)) == false){
                set.add(str.charAt(i));
                uniqueStr += str.charAt(i);
            }
        }
        
        combination(0, uniqueStr, 0, k, "");
    }
    
    public static void combination(int cc, String str, int curSet, int totalSet, String asf){
        if(cc == str.length()){
            if(curSet == totalSet)
                System.out.println(asf);
            return;
        }
        
        combination(cc + 1, str, curSet + 1, totalSet, asf + str.charAt(cc));
        combination(cc + 1, str, curSet, totalSet, asf);
    }
}