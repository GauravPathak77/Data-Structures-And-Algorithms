import java.lang.reflect.Array;
import java.util.*;
public class Bellman_Ford_Algorithm2 {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;          
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V){
        int dist[] = new int[V];

        for(int i=0; i<V-1; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<V-1; i++){
            for(int j=0; j<graph.size(); j++){
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                   // relaxation
                    if(dist[u]!=Integer.MAX_VALUE && (dist[u] + wt < dist[v])){
                        dist[v] = dist[u] + wt ;
                    }
                }
            }

        // print
        for(int i=0; i<V; i++){
            System.out.println(dist[i] + " ");
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many nodes Graph contain: ");
            int v = sc.nextInt();
            ArrayList<Edge> graph = new ArrayList<>();

            char ch;
            do {
                System.out.print("Enter value of source: ");
                int src = sc.nextInt();
                System.out.print("Enter value of destination: ");
                int dest = sc.nextInt();
                System.out.print("Enter weigth of edge between source to destination: ");
                int wt = sc.nextInt();
                graph.add(new Edge(src, dest, wt));
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.print("/nEnter Source: ");
            int src = sc.nextInt();
            System.out.println("\nBellman Ford Algorithm: ");
            bellmanFord(graph, src, graph.size());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
