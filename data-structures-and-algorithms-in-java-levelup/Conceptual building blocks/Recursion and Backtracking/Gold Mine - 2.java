import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    public static void getMaxGold(int[][] arr){
    
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j <arr[0].length; j++){
                /* initailly gold = 0 */
                goldCollected = 0;
                collectGold(arr, i, j, visited);
                /* after calling collectGold, it will collect the gold as one component of gold Area */
                /* update the max if max is less */
                if(goldCollected > max)
                    max = goldCollected;
            }
        }
    }
    
    static int goldCollected;
    public static void collectGold(int[][] arr, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0 || visited[i][j] == true)
            return;
        
        /* gold collected & marking as visited */
        goldCollected += arr[i][j];
        visited[i][j] = true;
        
        /* exploring all the four direction to collect gold */
        collectGold(arr, i - 1, j, visited);
        collectGold(arr, i + 1, j, visited);
        collectGold(arr, i, j + 1, visited);
        collectGold(arr, i, j - 1, visited);
    }
    
    
    public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
    	int n = scn.nextInt();
    	int m = scn.nextInt();
    	int[][] arr = new int[m][n];
    	for(int i = 0; i < arr.length; i++){
    		for(int j = 0 ; j  < arr[0].length; j++){
    			arr[i][j] = scn.nextInt();
    		}
    	}
    	getMaxGold(arr);
    	System.out.println(max);
    }
}