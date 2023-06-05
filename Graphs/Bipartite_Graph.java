import java.util.*;

public class Bipartite_Graph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++){
            if(col[i] == -1){
                col[i] = 0;
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1){
                            col[e.dest] = col[curr] == 0 ? 1 : 0;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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
                graph[src].add(new Edge(src, dest));
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            if (isBipartite(graph)) {
                System.out.println("\nGraph is Bipartite");
            } else {
                System.out.println("\nGraph is not Bipartite");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}