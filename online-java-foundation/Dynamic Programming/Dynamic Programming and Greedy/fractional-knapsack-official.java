import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for(int i = 0; i < n; i++){
            values[i] = sc.nextInt();
        }
        int[] weights = new int[n];
        for(int i = 0; i < n; i++){
            weights[i] = sc.nextInt();
        }
        int bagCap = sc.nextInt();
        float maxValue = solve(weights, values, bagCap);
        System.out.println(maxValue);
    }
    
    public static float solve(int[] weights, int[] values, int bagCap){
        sort(weights, values);
        
        float maxVal = 0;
        for(int i = 0; i < weights.length; i++){
            if(bagCap == 0){
                break;
            }else if(bagCap >= weights[i]){
                maxVal = maxVal + values[i];
                bagCap = bagCap - weights[i];
            }else{
                /* BagCap != 0, so take fractional part of current values */
                float unit = (float)values[i] / (float)weights[i];
                maxVal = maxVal + (unit * bagCap);
                break;
            }
        }    
        return maxVal;
    }
    
    private static void sort(int[] weights, int[] values){
        // sorting on the basis of (weights/values) in decreasing order
        for(int i = 0; i < weights.length; i++){
            boolean isAlreadySorted = true;
            for(int j = 0; j < weights.length - i - 1; j++){
                float cond1 = (float)weights[j] / (float)values[j];
                float cond2 = (float)weights[j + 1] / (float)values[j + 1];
                if(cond1 > cond2){
                    // swapping the weights
                    int temp = weights[j];
                    weights[j] = weights[j + 1];
                    weights[j + 1] = temp;
                    // swapping the values
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    // setting flag to false
                    isAlreadySorted = false;
                }
            }
            if(isAlreadySorted == true){
                break;
            }
        }
    }
}