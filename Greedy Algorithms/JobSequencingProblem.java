import java.util.*;
public class JobSequencingProblem {
    static class Job{
        int deadline;
        int profit;
        int id;
        public Job(int d, int p, int i){
            deadline = d;
            profit = p;
            id = i;
        }
        public static void main(String args[]){
            try(Scanner sc = new Scanner(System.in)){
                System.out.print("How many jobs are given: ");
                int size = sc.nextInt();
                int jobsInfo[][] = new int[size][2];
                ArrayList<Job> jobs = new ArrayList<>();
                for(int i=0; i<size; i++){
                    System.out.print("Enter deadline of job " + (i+1) + ": ");
                    jobsInfo[i][0] = sc.nextInt();
                    System.out.print("Enter profit of job " + (i + 1) + ": ");
                    jobsInfo[i][1] = sc.nextInt();
                    jobs.add(new Job(jobsInfo[i][0], jobsInfo[i][1], i));
                }

                Collections.sort(jobs, (object1, object2) -> object2.profit - object1.profit);
                ArrayList<Integer> seq = new ArrayList<>();
                int time = 0;
                for(int i=0; i<size; i++){
                    Job curr = jobs.get(i);
                    if(curr.deadline > time){
                        seq.add(curr.id);
                        time++;
                    }
                }

                System.out.println("MAximum Jobs done is: " + seq.size());
                for(int i=0; i<seq.size(); i++){
                    System.out.print(seq.get(i) + " ");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
