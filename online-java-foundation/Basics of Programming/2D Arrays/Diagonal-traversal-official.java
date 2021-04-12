import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        
        for(int gap = 0; gap < matrix.length; gap++){
            for(int i = 0, j = gap; j < matrix[0].length; i++, j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
}