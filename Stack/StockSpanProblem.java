import java.util.*;
public class StockSpanProblem {
    public static void stockSpan(int stock[], int span[]){
        Stack <Integer>s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1; i<stock.length; i++){
            int currhigh = stock[i];
            while(!s.isEmpty() && currhigh>stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevhigh = s.peek();
                span[i] = i - prevhigh;
            }
            s.push(i);
        }
        for(int i=0; i<span.length; i++){
            System.out.println("Span of day " + (i+1) + " of week is : " + span[i]);
        }
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            int stock[] = new int[7];
            for(int i=0; i<7; i++){
                System.out.print("Enter Price of day " + (i+1) + " of the week : ");
                stock[i] = sc.nextInt();
            }
            int span[] = new int[7];
            stockSpan(stock,span);
        }
    }
}
