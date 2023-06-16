import java.util.*;
public class Dijkastra_Algorithm {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }

    public static void dijkastra(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[graph.length];
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;

                // Neighbours

                for(int i=0; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[v] + wt < dist[u]){
                        dist[u] = dist[v] + wt;
                    }
                    pq.add(new Pair(e.dest, dist[u]));
                }
            }
        }
        // Print
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i] + "  ");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many nodes Graph contain: ");
            int v = sc.nextInt();
            ArrayList<Edge>[] graph = new ArrayList[v];

            for (int i = 0; i < v; i++) {
                graph[i] = new ArrayList<>();
            }
            char ch;
            do {
                System.out.print("Enter value of source: ");
                int src = sc.nextInt();
                System.out.print("Enter value of destination: ");
                int dest = sc.nextInt();
                System.out.print("Enter weigth of edge between source to destination: ");
                int wt = sc.nextInt();
                graph[src].add(new Edge(src, dest, wt));
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.print("/nEnter Source: ");
            int src = sc.nextInt();
            System.out.println("\nDijkastra Algorithm: ");
            dijkastra(graph, src);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
