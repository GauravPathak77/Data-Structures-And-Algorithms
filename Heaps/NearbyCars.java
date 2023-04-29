import java.util.*;
public class NearbyCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            PriorityQueue<Point> pq = new PriorityQueue<>();
            int i = 0;
            char ch;
            do{
                System.out.print("Enter x coordinate of car " + i + ": ");
                int x = sc.nextInt();
                System.out.print("Enter y coordinate of car " + i + ": ");
                int y = sc.nextInt();
                int distSq = x*x + y*y;
                pq.add(new Point(x, y, distSq, i++));
                System.out.print("Wanter to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');
            
            System.out.print("\nHow many nearest car you want to find: ");
            int k = sc.nextInt();
            for(int j=0; j<k; j++){
                System.out.println("Car" + pq.remove().idx);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
