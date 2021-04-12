import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        
        /* sorting the 2D array based on column 0 */
        sort2DArray(arr, 0);
        
        Deque<Pair> queue = new LinkedList<>();
        queue.add(new Pair(arr[0][0], arr[0][1]));
        
        /* filling the queue with result of merging arr */
        for(int i = 1; i < arr.length; i++){
            Pair peek = queue.peekLast();
            if(peek.end >= arr[i][0]){
                peek.end = Math.max(peek.end, arr[i][1]);
            }else{
                queue.add(new Pair(arr[i][0], arr[i][1]));
            }
        }
        
        /* Printing the result from deque */
        while(queue.size() > 0){
            Pair p = queue.removeFirst();
            System.out.println(p.st + " " + p.end);
        }
        
    }

    static class Pair{
        int st;
        int end;
        public Pair(int st, int end){
            this.st = st;
            this.end = end;
        }
    }

    private static void sort2DArray(int[][] arr, int colIdx){
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(final int[] a, final int[] b){
                return a[colIdx] - b[colIdx];
            }
        });
    }
}