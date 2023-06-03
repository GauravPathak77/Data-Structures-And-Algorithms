import java.util.*;
public class Has_Path {
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

    // Has Path using DFS
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]){
        if(src == dest){
            return true;
        }

        vis[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
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
                System.out.print("Enter value of weight: ");
                int wt = sc.nextInt();
                graph[src].add(new Edge(src, dest, wt));
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.print("\nEnter source of path: ");
            int s = sc.nextInt();
            System.out.print("Enter destination of path: ");
            int d = sc.nextInt();
            if(hasPath(graph, s, d, new boolean[v])){
                System.out.println("\nPath exists between " + s + " and " + d);
            }
            else{
                System.out.println("\nPath does not exists between " + s + " and " + d);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
