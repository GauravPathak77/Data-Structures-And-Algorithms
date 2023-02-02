import java.util.*;
public class MaxLengthChainOfPairs {
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("How many pairs do you want to enter? ");
            int size = sc.nextInt();
            int pairs[][] = new int[size][2];
            for(int i=0; i<size; i++){
                System.out.println("Enter elements in pair " + (i+1) + ": ");
                pairs[i][0] = sc.nextInt();
                pairs[i][1] = sc.nextInt();
            }

            Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

            int chainLen = 1;
            int chainEnd = pairs[0][1];

            for(int i=1; i<pairs.length; i++){
                if(pairs[i][0] > chainEnd){
                    chainLen++;
                    chainEnd = pairs[i][1];
                }
            }

            System.out.println("Maximum Length of chain is: " + chainLen);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
