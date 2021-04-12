import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;
        
        Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
    
        
        boolean[] visited = new boolean[vtces];
        /* using prim's algorithm to find the minum spanning tree from the vertex 0*/
        printMinimumSpanningTree(graph, 0, visited);
    }

    static class Pair implements Comparable<Pair>{
        int vt;
        int parent;
        int wt;
        public Pair(int vt, int parent, int wt){
            this.vt = vt;
            this.parent = parent;
            this.wt = wt;
        }
        
        public int compareTo(Pair pair){
            return this.wt - pair.wt;
        }
    }

    public static void printMinimumSpanningTree(ArrayList<Edge>[] graph, int src, boolean[] visited){
        
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        /* for src vertex, there is no parent and from src to src there is no weight i.e 0 */
        queue.add(new Pair(src, -1, 0));
        
        while(queue.size() > 0){
            Pair peek = queue.remove();
            
            if(visited[peek.vt] == true)
                continue;
                
            visited[peek.vt] = true;
            if(peek.parent != -1)
                System.out.println("[" + peek.vt + "-" + peek.parent +"@" + peek.wt + "]");
                
            for(Edge e : graph[peek.vt]){
                if(visited[e.nbr] == false)
                    queue.add(new Pair(e.nbr, peek.vt, e.wt));
            }
        }
        
    }
}