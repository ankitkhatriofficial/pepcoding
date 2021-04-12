import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int row = sc.nextInt();
        int col = sc.nextInt();
        
        int[][] mine = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j< col; j++){
                mine[i][j] = sc.nextInt();
            }
        }
        
        int maxGold = collectGold(mine);
        System.out.println(maxGold);
    }

    public static int collectGold(int[][] mine){
        int[][] dp = new int[mine.length][mine[0].length];
        
        /* copy right wall (dest) of mine to dp */
        for(int i = dp.length - 1, j = dp[0].length - 1; i >= 0; i--){
            dp[i][j] = mine[i][j];
        }
        
        /* start filling the rest of the dp */
        for(int j = dp[0].length - 2; j >= 0; j--){
            for(int i = dp.length - 1; i >= 0; i--){
               if(i == dp.length - 1){
                   int max = Math.max(dp[i][j+1], dp[i-1][j+1]);
                   dp[i][j] = mine[i][j] + max;
               }else if(i == 0){
                   int max = Math.max(dp[i][j+1], dp[i+1][j+1]);
                   dp[i][j] = mine[i][j] + max;
               }else{
                   int max = Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]));
                   dp[i][j] = mine[i][j] + max;
               }
            }
        }
        
        /* find maximum in 1st column of dp */
        int max = Integer.MIN_VALUE;
        for(int i = 0, j = 0; i < dp.length; i++){
            if(dp[i][j] > max){
                max = dp[i][j];
            }
        }
        return max;
    }
}