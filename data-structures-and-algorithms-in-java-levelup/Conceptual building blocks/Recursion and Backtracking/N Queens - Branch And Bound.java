import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];

        solution(board, "", 0);    
    }
    
    public static void solution(boolean[][] chess, String qsf, int row){
        if(row == chess.length){
            System.out.println(qsf + ".");
            return;
        }
        
        for(int col = 0; col < chess[row].length; col++){
            boolean isSafe = isSafeToSitQueen(chess, row, col);
            if(isSafe == true){
                chess[row][col] = true;
                solution(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = false;
            }
        }
    }
    
    public static boolean isSafeToSitQueen(boolean[][] chess, int i, int j){
        
        for(int row = i - 1, col = j; row >= 0; row--){
            if(chess[row][col] == true)
                return false;
        }
        
        for(int row = i - 1, col = j -1; row >= 0 && col >= 0; row-- , col--){
            if(chess[row][col] == true)
                return false;
        }
        
        for(int row = i - 1, col = j + 1; row >= 0 && col < chess[0].length; row--, col++){
            if(chess[row][col] == true)
                return false;
        }
        
        return true;
    }
    
}