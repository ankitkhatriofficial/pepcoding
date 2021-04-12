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
    
    static class Pair{
        int vt;
        String psf;
        
        public Pair(int vt, String psf){
            this.vt = vt;
            this.psf = psf;
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
        
        boolean[] visited = new boolean[vtces];
        iterativeDSF(graph, src, visited);
    }
    
    public static void iterativeDSF(ArrayList<Edge>[] graph, int src, boolean[] visited){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(src, src + ""));
        
        while(st.size() > 0){
            Pair peek = st.pop();
            
            if(visited[peek.vt] == true)
                continue;
            
            visited[peek.vt] = true;
            System.out.println(peek.vt + "@" + peek.psf);
            for(Edge e : graph[peek.vt]){
                if(visited[e.nbr] == false)
                    st.push(new Pair(e.nbr, peek.psf + e.nbr));
            }
        }
    }
}