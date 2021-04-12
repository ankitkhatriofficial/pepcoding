import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        
        Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        
        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        
        boolean[] visited = new boolean[vtces];
        
        int infectedPersons = count(graph, src, visited, t);
        System.out.println(infectedPersons);
    }
    
    static class Pair{
        int vt;
        int time;
        
        public Pair(int vt, int time){
            this.vt = vt;
            this.time = time;
        }
    }

    public static int count(ArrayList<Edge>[] graph, int src, boolean[] visited, int time){
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 1));
        
        int count = 0;
        while(queue.size() > 0){
            Pair peek = queue.remove();
            
            if(peek.time > time)
                break;
                
            if(visited[peek.vt] == true)
                continue;
                
            visited[peek.vt] = true;
            count++;
            for(Edge e : graph[peek.vt]){
                if(visited[e.nbr] == false)
                    queue.add(new Pair(e.nbr, peek.time + 1));
            }
        }
        
        return count;
    }
}