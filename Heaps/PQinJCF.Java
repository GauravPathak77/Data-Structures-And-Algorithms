import java.util.*;
public class PQinJCF {
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
        char ch;
        do{
            System.out.print("Enter value in Priority Queue: ");
            int data = sc.nextInt();
            pq.add(data);
            System.out.print("Want to enter more values(y/n)? ");
            ch = sc.next().charAt(0);
        }while(ch == 'y' || ch == 'Y');

        System.out.println("\nPriority Queue is: ");
        while(!pq.isEmpty()){
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}