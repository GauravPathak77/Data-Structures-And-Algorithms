public class AllOccurence {
    public static void allOccurence(int arr[], int key, int i) {
        // base case
        if(i == arr.length) {
            return;
        }
        // kaam
        if(arr[i] == key) {
            System.out.print(i+" ");
        }
        allOccurence(arr, key, i+1);
    } 
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        allOccurence(arr, 2, 0);
    }
}
