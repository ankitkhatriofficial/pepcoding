import java.io.*;
import java.util.*;

public class Main{
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        
        solve(a, k);
    }
    
    public static void solve(int[] arr, int k){
        
        Stack<Integer> st = new Stack<>();
        
        int[] nge = new int[arr.length]; // next greater element
        nge[nge.length - 1] = nge.length;
        st.push(nge.length - 1);
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0)
                nge[i] = arr.length;
            else
                nge[i] = st.peek();
            st.push(i);
        }
        
        for(int i = 0; i <= (arr.length - k); i++){
            int window = i + k;
            int j = i;
            while(nge[j] < window)
                j = nge[j];
                
            System.out.println(arr[j]);
        }
    }
}