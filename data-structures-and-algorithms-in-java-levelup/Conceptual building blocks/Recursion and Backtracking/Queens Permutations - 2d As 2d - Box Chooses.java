import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf + "\n");
            }
            return;
        }

        int nrow = 0;
        int ncol = 0;
        char sep = ' ';
        if(col == tq - 1){
            nrow = row + 1;
            ncol = 0; 
            sep = '\n';
        }else{
            nrow = row;
            ncol = col + 1;
            sep = '\t';
        }
        
        for(int i = 0; i < tq; i++){
            if(queens[i] == false){
                queens[i] = true;
                queensPermutations(qpsf + 1, tq, nrow, ncol, (asf + "q" + (i + 1) + sep), queens);
                queens[i] = false;                
            }
        }
        
        queensPermutations(qpsf, tq, nrow, ncol, asf + "-" + sep, queens);
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}