import java.util.*;
public class FractionalKnapsack{
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter size of values: ");
            int size = sc.nextInt();
            int val[] = new int[size];
            int weight[] = new int[size];
            double ratio[][] = new double[val.length][2];

            System.out.println("Enter values: ");
            for(int i=0; i<size; i++){
                val[i] = sc.nextInt();
            }
            System.out.println("Enter weight of values: ");
            for (int i = 0; i < size; i++) {
                weight[i] = sc.nextInt();
            }
            System.out.print("Enter capacity: ");
            int capacity = sc.nextInt();

            for (int i = 0; i < val.length; i++) {
                ratio[i][0] = i;
                ratio[i][1] = val[i] / (double) weight[i];
            }

            // ascending order
            Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

            int finalValue = 0;
            for (int i = ratio.length - 1; i >= 0; i--) {
                int idx = (int) ratio[i][0];
                if (capacity >= weight[idx]) {
                    // Include full item
                    finalValue += val[idx];
                    capacity -= weight[idx];
                } else {
                    // Include fractional item
                    finalValue += ratio[i][1] * capacity;
                    capacity = 0;
                    break;
                }
            }
            System.out.println("Final value = " + finalValue);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}