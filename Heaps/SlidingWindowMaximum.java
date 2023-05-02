import java.util.*;
public class SlidingWindowMaximum {
    static class Pair implements Comparable<Pair>{
        int idx;
        int value;
        public Pair(int idx, int value){
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.value - this.value;
        }
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            ArrayList<Integer> list = new ArrayList<>();
            char ch;
            do {
                System.out.print("Enter element: ");
                int data = sc.nextInt();
                list.add(data);
                System.out.print("Want to enter more elements?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            System.out.print("\nEnter size of window: ");
            int k = sc.nextInt();
            int res[] = new int[list.size() - k + 1];
            // 1st window
            for(int i=0; i<k; i++){
                pq.add(new Pair(list.get(i), i));
            }
            res[0] = pq.remove().value;
            // for rest elements
            for(int i=k; i<list.size(); i++){
                while(pq.size()>0 && pq.peek().idx <= (i-k)){
                    pq.remove();
                }
                pq.add(new Pair(list.get(i), i));
                res[i-k+1] = pq.peek().value;
            }
            System.out.println("\nSliding Maximum window is: ");
            for(int i=0; i<res.length; i++){
                System.out.print(res[i] + " ");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
