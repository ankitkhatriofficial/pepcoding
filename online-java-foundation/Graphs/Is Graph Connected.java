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
        
        /* if the graph is connected you can visit from one vertex to all other vertex */
        /* here i am taking vextex as 0 as src and if through 0 vertex i can visit all other
        * vertex then the graph is connected
        */
        
        boolean[] visited = new boolean[vtces];
        
        /* after calling this recursive function, if any of the vtces in visited remains false then
        we can say the graph is not connected otherwise connected */
        isConnectedMarkTrue(graph, 0, visited);
        
        for(boolean val : visited){
            if(val == false){
                System.out.println(false);
                return;
            }
        }
        
        System.out.println(true);
    }
    
    public static void isConnectedMarkTrue(ArrayList<Edge>[] graph, int vt, boolean[] visited){
        
        visited[vt] = true;
        for(Edge e : graph[vt]){
            if(visited[e.nbr] == false)
                isConnectedMarkTrue(graph, e.nbr, visited);
        }
        
    }
}