import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        
        while(i < j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

	public static void solution(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }		
        
        for(int i = 0; i < str.length(); i++){
            String prefix = str.substring(0, i + 1);
            String roq = str.substring(i + 1);
            if(isPalindrome(prefix) == true)
                solution(roq, asf + "(" + prefix + ") ");
        } 
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "");
	}

}