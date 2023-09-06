import java.util.*;
public class Maximum_Elements {
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }
    public static void buildST(int i, int si, int sj, int arr[]){
        if(si == sj){
            tree[i] = arr[si];
            return;
        }
        int mid = (si+sj)/2;
        buildST(2*i+1, si, mid, arr);
        buildST(2*i+2, mid+1, sj, arr);
        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj){
        if(si> qj || sj < qi){
            return Integer.MIN_VALUE;
        }
        else if(si >= qi && sj <= qj){
            return tree[i];
        }
        else{
            int mid = (si+sj)/2;
            int left = getMaxUtil(2*i+1, si, mid, qi, qj);
            int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }
    public static int getMax(int arr[], int qi, int qj){
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }
    public static void updateUtil(int i, int si, int sj, int idx, int newVal){
        if(idx < si || idx > sj){
            return;
        }
        tree[idx] = Math.max(tree[idx], newVal);
        if(si != sj){
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
        }
    }
    public static void update(int arr[], int idx, int newVal){
        tree[idx] = newVal;
        int n = arr.length;
        updateUtil(0, 0, n-1, idx, newVal);
    }
    
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();
            init(n);
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter element " + (i+1) + " : ");
                arr[i] = sc.nextInt();
            }
            buildST(0, 0, n-1, arr);
            System.out.println("\nBefore updation");
            System.out.print("Enter the starting index of range to find maximum element: ");
            int qi = sc.nextInt();
            System.out.print("Enter the ending index of range to find maximum element: ");
            int qj = sc.nextInt();
            System.out.println("Maximum element is: " + getMax(arr, qi, qj));
            System.out.print("Enter newValue to update: ");
            int newValue = sc.nextInt();
            System.out.print("Enter index to update: ");
            int idx = sc.nextInt();
            update(arr, idx, newValue);
            System.out.print("\nAfter updation");
            System.out.println("Maximum element is: " + getMax(arr, qi, qj));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
