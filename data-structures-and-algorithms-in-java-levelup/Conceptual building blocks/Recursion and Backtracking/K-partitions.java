import java.io.*;
import java.util.*;

public class Main {

    static int count = 1;
	public static void solution(int i, int n, int k, int noOfsets, ArrayList<ArrayList<Integer>> ans) {
		if(i > n){
		    if(noOfsets == k){
    		    System.out.print(count++ + ". ");
    		    for(ArrayList<Integer> set : ans)
    		        System.out.print(set + " ");
    		    System.out.println();
		    }
		    return;
		}
		
		for(int j = 0; j < ans.size(); j++){
		    ArrayList<Integer> set = ans.get(j);
		    if(set.size() > 0){
                	set.add(i);
                	solution(i + 1, n , k, noOfsets, ans);
                	set.remove(set.size() - 1);
		    }else{
                	set.add(i);
                	solution(i + 1, n , k, noOfsets + 1, ans);
                	set.remove(set.size() - 1);
                	break;
		    }
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);
	}
}