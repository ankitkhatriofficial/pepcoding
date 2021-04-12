import java.io.*;
import java.util.*;

public class Main {
    
    static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;
        
        public Pair(int li, int di, int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }
        
        public int compareTo(Pair p){
            return this.val - p.val;
        }
        
        public String toString(){
            return val + "";
        }
    }
    
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 0; i < lists.size(); i++){
            pq.add(new Pair(i, 0, lists.get(i).get(0)));
        }
        
        while(pq.size() > 0){
            Pair pair = pq.remove();
            rv.add(pair.val);
            pair.di++;
            if(pair.di < lists.get(pair.li).size()){
                pair.val = lists.get(pair.li).get(pair.di);
                pq.add(pair);
            }
        }
        
        return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}