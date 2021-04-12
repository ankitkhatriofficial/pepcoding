import java.io.*;
import java.util.*;

public class Main{
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
           arr[i] = Integer.parseInt(br.readLine());
        }
    
        int maxArea = largestHistogram(arr);
        System.out.println(maxArea);
    }
    
    public static int largestHistogram(int[] arr){
        Stack<Integer> st = new Stack<>();
        
        int[] nseL = new int[arr.length]; // next smaller element's Index on Left
        nseL[0] = -1;
        st.push(0);
        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[st.peek()] >= arr[i])
                st.pop();
            if(st.size() == 0)
                nseL[i] = -1;
            else
                nseL[i] = st.peek();
            st.push(i);
        }
        
        st = new Stack<>();
        
        int[] nseR = new int[arr.length]; // next smaller element's Index on Right
        nseR[nseR.length - 1] = arr.length;
        st.push(nseR.length - 1);
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[st.peek()] >= arr[i])
                st.pop();
            if(st.size() == 0)
                nseR[i] = arr.length;
            else
                nseR[i] = st.peek();
            st.push(i);
        }
        
        int maxArea = 0;
        for(int i = 0; i < arr.length; i++){
            int length = nseR[i] - nseL[i] - 1;
            int area = length * arr[i];
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}