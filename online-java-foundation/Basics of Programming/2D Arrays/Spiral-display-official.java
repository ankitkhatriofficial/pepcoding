import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int minr = 0;
        int minc = 0;
        int maxr = row - 1; //arr.length - 1
        int maxc = col - 1; //arr[0].length - 1
        
        int totalElements = row * col;
        int count = 0;
        
        while(count < totalElements){
            //print left wall
            for(int i = minr, j = minc; i <= maxr && count < totalElements; i++){
                System.out.println(matrix[i][j]);
                count++;
            }
            minc++;
            //print bottom wall
            for(int i = maxr, j = minc; j <= maxc && count < totalElements; j++){
                System.out.println(matrix[i][j]);
                count++;
            }
            maxr--;
            //print right wall
            for(int i = maxr, j = maxc; i >= minr && count < totalElements; i--){
                System.out.println(matrix[i][j]);
                count++;
            }
            maxc--;
            //print top wall
            for(int i = minr, j = maxc; j >= minc && count < totalElements; j--){
                System.out.println(matrix[i][j]);
                count++;
            }
            minr++;
        }
    }
}