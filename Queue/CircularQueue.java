import java.util.*;
public class CircularQueue{
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        Queue(int N){
            arr = new int[N];
            size = N;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public static boolean isFull(){
            return (rear+1) % size == front;
        }

        //add
        public static void add(int data){
            if(isFull()){
                System.out.println(" Queue is Full ");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear+1) % size;
            arr[rear] = data;
        }
        
        // remove
        public static int remove(){
            if(isEmpty()){
                return -1;
            }
            int result = arr[front];
            if(rear == front){
                rear = front = -1;
            }
            else{
                front = (front + 1) % size;
            }
            return result;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return arr[front];
        }
    }
    
    public static void main(String args[]) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek() + " ");
            q.remove();
        }
    }
}