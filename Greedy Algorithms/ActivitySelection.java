import java.util.*;
public class ActivitySelection{
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter size of start: ");
            int stSize = sc.nextInt();
            int start[] = new int[stSize];
            System.out.println("Enter values of start time: ");
            for(int i =0; i<stSize; i++){
                start[i] = sc.nextInt();
            }
            System.out.print("Enter size of end: ");
            int endSize = sc.nextInt();
            int end[] = new int[endSize];
            System.out.println("Enter values of end time: ");
            for (int i = 0; i < endSize; i++) {
                end[i] = sc.nextInt();
            }
            int activities[][] = new int[start.length][3];
            for (int i = 0; i < start.length; i++) {
                activities[i][0] = i;
                activities[i][1] = start[i];
                activities[i][2] = end[i];
            }

            // lambda function
            Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

            int maxAct = 0;
            ArrayList<Integer> ans = new ArrayList<>();

            ans.add(activities[0][0]);
            maxAct = 1;
            int lastEnd = activities[0][2];

            for (int i = 1; i < end.length; i++) {
                if (activities[i][1] >= lastEnd) {
                    maxAct++;
                    ans.add(activities[i][0]);
                    lastEnd = activities[i][2];
                }
            }

            System.out.println("Maximum Activities = " + maxAct);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("A" + ans.get(i) + " ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}