import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
		int fact = factorial(str.length());
		for(int i = 0; i < fact; i++){
		    int temp = i;
		    StringBuilder sb = new StringBuilder(str);
		    for(int j = str.length(); j >= 1; j--){
		        int rem = temp % j;
		        System.out.print(sb.charAt(rem));
		        sb.deleteCharAt(rem);
		        temp = temp / j;
		    }
		    System.out.println();
		}
	}
	
	private static int factorial(int n){
	    int fact = 1;
	    for(int i = 2; i <= n; i++){
	        fact = fact * i;
	    }
	    return fact;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}