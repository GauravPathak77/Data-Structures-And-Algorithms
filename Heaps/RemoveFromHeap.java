import java.util.*;
public class RemoveFromHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // Insert at last index
            arr.add(data);
            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            while (arr.get(x) < arr.get(par)) {
                int temp = x;
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }
        }
        // heapify
        private void heapify(int i){
            int left = (2*i) + 1;
            int right = (2*i) + 2;
            int minidx = i;
            
            if(left < arr.size() && arr.get(minidx) > arr.get(left)){
                minidx = left;
            }

            if(right < arr.size() && arr.get(minidx) > arr.get(right)){
                minidx = right;
            }

            // swap
            if(minidx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);
                heapify(minidx);
            }
        }
        public int peek() {
            return arr.get(0);
        }

        public int remove(){
            int data = arr.get(0);

            // swap
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // remove last
            arr.remove(arr.size()-1);

            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            Heap h = new Heap();
            char ch;
            do {
                System.out.print("Enter value in Heap: ");
                int data = sc.nextInt();
                h.add(data);
                System.out.print("Want to enter more values(y/n)? ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.println("\nHeap is: ");
            while (!h.isEmpty()) {
                System.out.print(h.peek() + " ");
                h.remove();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
