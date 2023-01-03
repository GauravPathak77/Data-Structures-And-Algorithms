import java.util.*;
public class NextGreaterElement {
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            Stack <Integer>s = new Stack<>();
            System.out.println("Enter size of array: ");
            int size = sc.nextInt();
            int arr[] = new int[size];
            int nxtGreater[] = new int[size];
            System.out.println("Enter elements in an array: ");
            for(int i=0; i<size; i++){
                arr[i] = sc.nextInt();
            }

            for(int i=arr.length-1; i>=0; i--){
                while(!s.isEmpty() && arr[i]>=arr[s.peek()]){
                    s.pop();
                }
                if(s.isEmpty()){
                    nxtGreater[i] = -1;
                }
                else{
                    nxtGreater[i] = arr[s.peek()];
                }
                s.push(i);
            }
            for(int i=0; i<size; i++){
                System.out.println("Next Greater Element of " + arr[i] + " is : " + nxtGreater[i]);
            }

        }
    }
}
