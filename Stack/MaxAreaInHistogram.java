import java.util.*;
public class MaxAreaInHistogram {
    public static void maxArea(int arr[]){
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        int maxArea = 0;
        
        //Next smaller Right
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsr[i] = arr.length;
            }
            else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Smaller Left
        s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Current Area
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] -1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }
        System.out.println("Maximum Area in histogram is: " + maxArea);
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            int size;
            System.out.print("Enter size of array: ");
            size = sc.nextInt();
            int arr[] = new int[size];
            System.out.println("Enter height of bars: ");
            for(int i=0; i<size; i++){
                arr[i] = sc.nextInt();
            }
            maxArea(arr);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
