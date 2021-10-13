import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void solveSudoku(int[][] board, int i, int j) {
        if(i == board.length){
            display(board);
            return;
        }
            
        int ni = 0;
        int nj = 0;
        
        if(j == board[0].length - 1){
            ni = i + 1;
            nj = 0;
        }else{
            ni = i;
            nj = j + 1;
        }
        
        if(board[i][j] != 0){
            solveSudoku(board, ni, nj);
        }else{
            for(int po = 1; po <= 9; po++){
                if(isValidPlace(board, i, j, po) == true){
                    board[i][j] = po;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                } 
            }
        }
    }
    
    private static boolean isValidPlace(int[][] board, int i, int j, int val){
        
        /* checking row */
        for(int row = i, col = 0; col < board[0].length; col++)
            if(board[row][col] == val)
                return false;
        
        /* checking col */
        for(int row = 0, col = j; row < board.length; row++){
            if(board[row][col] == val)
                return false;
        }
       
        /* checking submatrix */
        int cornerX = (i / 3) * 3;
        int cornerY = (j / 3) * 3;
        
        for(int row = cornerX; row < cornerX + 3; row++){
            for(int col = cornerY; col < cornerY + 3; col++){
                if(board[row][col] == val)
                    return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        solveSudoku(arr, 0, 0);
    }
}
