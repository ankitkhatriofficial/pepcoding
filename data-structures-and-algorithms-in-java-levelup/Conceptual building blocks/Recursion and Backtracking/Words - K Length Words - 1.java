import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
            unique.add(ch);
            ustr += ch;
            }
        }
        Character[] spot = new Character[k];
        permutation(0, ustr, 0, k, spot);
    }
    
    public static void permutation(int cc, String ustr, int cs, int k, Character[] spots){
        if(cc == ustr.length()){
            if(cs == k){
                for(Character ch : spots)
                        System.out.print(ch);
                    System.out.println();
            }
            return;
        }
        
        char ch = ustr.charAt(cc);
        for(int i = 0; i < spots.length; i++){
            if(spots[i] == null){
                spots[i] = ch;
                permutation(cc + 1, ustr, cs + 1, k, spots);
                spots[i] = null;
            }
        }
        permutation(cc + 1, ustr, cs, k, spots);        
    }
    
}