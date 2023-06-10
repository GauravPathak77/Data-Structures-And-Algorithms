import java.util.*;

public class Topological_Sorting_using_BFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]){
        for(int i=0; i<graph.length; i++){
            int v = i;
            for(int j=0; j<graph[v].size(); j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        // bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
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
                graph[src].add(new Edge(src, dest));
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.println("\nTopological Sorting Order: ");
            topSort(graph);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}