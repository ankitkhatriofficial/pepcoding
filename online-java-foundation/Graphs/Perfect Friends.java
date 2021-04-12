import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge{
        int src;
        int nbr;
        
        public Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        ArrayList<Edge>[] graph = new ArrayList[n];
        
        for(int v = 0; v < n; v++){
            graph[v] = new ArrayList<>();
        }   
        
        for(int i = 0; i < k; i++){
            String line = br.readLine();
            String[] parts = line.split(" ");
            
            int src = Integer.parseInt(parts[0]);
            int nbr = Integer.parseInt(parts[1]);
            
            graph[src].add(new Edge(src, nbr));
            graph[nbr].add(new Edge(nbr, src));
        }
        
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        
        boolean[] visited = new boolean[graph.length];
        for(int v = 0; v < graph.length; v++){
            if(visited[v] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                getComponent(graph, v, visited, comp);
                comps.add(comp);
            }
        }
        
        int pairs = 0; 
        for(int i = 0; i < comps.size(); i++){
            for(int j = i + 1; j < comps.size(); j++){
                pairs += comps.get(i).size() * comps.get(j).size();
            }
        }
        System.out.println(pairs);
    }

    public static void getComponent(ArrayList<Edge>[] graph, int vt, boolean[] visited, ArrayList<Integer> comp){
        
        visited[vt] = true;
        comp.add(vt);
        
        for(Edge e : graph[vt]){
            if(visited[e.nbr] == false)
                getComponent(graph, e.nbr, visited, comp);
        }
    }

}