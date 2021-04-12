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
        
        int target = sc.nextInt();
        
        int i = 0;
        int j = matrix[0].length - 1;
        
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                System.out.println(i);
                System.out.println(j);
                return;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        System.out.println("Not Found");
    }
}