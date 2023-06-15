import java.util.*;
public class All_Paths_from_source_to_target {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path){
        if(src == dest){
            System.out.print(path + dest);
            return;
        }
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
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
            System.out.print("\nEnter source: ");
            int src = sc.nextInt();
            System.out.print("Enter destination: ");
            int dest = sc.nextInt();
            printAllPath(graph, src, dest, "");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
