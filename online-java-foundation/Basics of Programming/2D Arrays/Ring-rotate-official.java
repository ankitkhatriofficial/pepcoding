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
        
        int shell = sc.nextInt();
        int rotate = sc.nextInt();
        
        rotateMatrix(matrix, shell, rotate);
        display(matrix);
    }
    
    public static void rotateMatrix(int[][] matrix, int shell, int rotate){
        int[] arr = getArrayFromMatrix(matrix, shell);
        rotateArrayByK(arr, rotate);
        fillArrayInMatrix(matrix, arr, shell);
    }
    
    private static int[] getArrayFromMatrix(int[][] matrix, int shell){
        
        int minr = shell - 1;
        int minc = shell - 1;
        int maxr = matrix.length - shell;
        int maxc = matrix[0].length - shell;
        
        int ArrSize = 2 * ((maxc - minc + maxr - minr + 2)) - 4;
        
        int[] arr = new int[ArrSize];
        int idx = 0;
        
        //fill left wall
        for(int i = minr, j = minc; i <= maxr; i++){
            arr[idx] = matrix[i][j];
            idx++;
        }
        //fill bottom wall
        for(int i = maxr, j = minc + 1; j <= maxc; j++){
            arr[idx] = matrix[i][j];
            idx++;
        }
        //fill right wall
        for(int i = maxr - 1, j = maxc; i >= minr; i--){
            arr[idx] = matrix[i][j];
            idx++;
        }
        //fill top wall
        for(int i = minr, j = maxc - 1; j > minr; j--){
            arr[idx] = matrix[i][j];
            idx++;
        }
        return arr;
    }
    
    private static void fillArrayInMatrix(int[][] matrix, int[] arr, int shell){
        
        int minr = shell - 1;
        int minc = shell - 1;
        int maxr = matrix.length - shell;
        int maxc = matrix[0].length - shell;
        
        int idx = 0;
        
        //fill left wall
        for(int i = minr, j = minc; i <= maxr; i++){
            matrix[i][j] = arr[idx];
            idx++;
        }
        //fill bottom wall
        for(int i = maxr, j = minc + 1; j <= maxc; j++){
            matrix[i][j] = arr[idx];
            idx++;
        }
        //fill right wall
        for(int i = maxr - 1, j = maxc; i >= minr; i--){
            matrix[i][j] = arr[idx];
            idx++;
        }
        //fill top wall
        for(int i = minr, j = maxc - 1; j > minr; j--){
            matrix[i][j] = arr[idx];
            idx++;
        }
    }
    
    private static void rotateArrayByK(int[] arr, int k){
        k = k % arr.length;
        if(k < 0){
            k = k + arr.length;
        }
        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }
    
    private static void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}