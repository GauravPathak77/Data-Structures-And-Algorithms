import java.util.*;
public class ConnectNropes {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int ch;
            int cost = 0;
            do{
                System.out.print("Enter length of ropes: ");
                int rope = sc.nextInt();
                pq.add(rope);
                System.out.print("Want to enter more ropes?(y/n): ");
                ch= sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');

            while(pq.size() > 1){
                int min = pq.remove();
                int min2 = pq.remove();
                cost +=  min + min2;
                pq.add(min + min2);
            }

            System.out.println("\nCost of ropes is: " + cost);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
