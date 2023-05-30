import java.util.*;
public class Creating_a_Graph{
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

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("How many nodes Graph contain: ");
            int v = sc.nextInt();
            ArrayList<Edge>[] graph = new ArrayList[v];

            for(int i=0; i<v; i++){
                graph[i] = new ArrayList<>();
            }
            char ch;
            do{
                System.out.print("Enter value of source: ");
                int src = sc.nextInt();
                System.out.print("Enter value of destination: ");
                int dest = sc.nextInt();
                System.out.print("Enter value of weight: ");
                int wt = sc.nextInt();
                graph[src].add(new Edge(src, dest, wt));
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');

            System.out.print("\nEnter the value whose neighbour you want to see: ");
            int s = sc.nextInt();

            for(int i=0; i<graph[s].size(); i++){
                Edge e = graph[s].get(i);
                System.out.print(e.dest + " ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}