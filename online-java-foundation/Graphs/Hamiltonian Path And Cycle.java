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
        
        int src = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        printHamiltonPathAndCycle(graph, src, visited, src + "", src, 0);
    }

    public static void printHamiltonPathAndCycle(ArrayList<Edge>[] graph, int src, boolean[] visited, String psf, int osrc, int count){
        if(count == graph.length - 1){
            System.out.print(psf);
            
            for(Edge e : graph[src]){
                if(e.nbr == osrc){
                    System.out.println("*");
                    return;
                }
            }
            System.out.println(".");
            return;
        }
        
        visited[src] = true;
        count++;
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                printHamiltonPathAndCycle(graph, e.nbr, visited, psf + e.nbr, osrc, count);
            }
        }
        visited[src] = false;
    }

}