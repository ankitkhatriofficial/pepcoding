import java.io.*;
import java.util.*;

public class Main {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		
		if(cs > ts){
		    String rev = "";
		    for(int i = asf.length() - 1; i >= 0; i--)
		        rev += asf.charAt(i);
		        
		    String res = asf;
		    if(oddc != null)
		        res += oddc;
		    res += rev;
		    System.out.println(res);
		    return;
		}
		
		for(Character key : fmap.keySet()){
		    int freq = fmap.get(key);
		    if(freq > 0){
    		    fmap.put(key, freq - 1);
    		    generatepw(cs + 1, ts, fmap, oddc, asf + key);
    		    fmap.put(key, freq);
    		 }
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(fmap.containsKey(ch))
			    fmap.put(ch, fmap.get(ch) + 1);
			else
			    fmap.put(ch, 1);
		}
		
		int odds = 0;
		int strLength = 0;
		Character oddCh = null;
		
		for(Character key : fmap.keySet()){
		    int value = fmap.get(key);
		    
		    if(value % 2 == 1){
		        odds++;
		        oddCh = key;
		    }
		    
		    fmap.put(key, value / 2);
		    strLength += value / 2;
		}
		
	    if(odds > 1){
	        System.out.println(-1);
	        return;
	    }
		generatepw(1, strLength, fmap, oddCh, "");
	}
	
}