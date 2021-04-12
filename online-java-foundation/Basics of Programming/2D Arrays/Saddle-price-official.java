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
        
        for(int i = 0; i < matrix.length; i++){
            
            int svj = 0;
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < matrix[i][svj]){
                    svj = j;
                }
            }
            
            boolean flag = true;
            for(int k = 0; k < matrix.length; k++){
                if(matrix[k][svj] > matrix[i][svj]){
                    flag =  false;
                    break;
                }
            }
            
            if(flag == true){
                System.out.println(matrix[i][svj]);
                return;
            }
        }
        System.out.println("Invalid input");
    }
}