import java.util.*;
public class PQforObjects {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }

    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            PriorityQueue<Student> pq = new PriorityQueue<>();
            char ch;
            do {
                System.out.print("Enter name of student: ");
                String name = sc.next();
                System.out.print("Enter rank of student: ");
                int rank = sc.nextInt();
                pq.add(new Student(name, rank));
                System.out.print("Want to enter more values(y/n)? ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.println("\nStudents are: ");
            while (!pq.isEmpty()) {
                System.out.println(pq.peek().name + " -> " + pq.peek().rank);
                pq.remove();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
