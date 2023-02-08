import java.util.*;
public class DiagonalSum {
    public static int diagonalSum(int matrix[][]){
        int sum = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(i == j){
                    sum += matrix[i][j];
                }
                else if(i+j == matrix.length-1){
                    sum += sum;
                }
            }
        }
        sum -= matrix[matrix.length/2][matrix[0].length/2];
        return sum;
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of rows: ");
            int m = sc.nextInt();
            System.out.print("Enter size of columns: ");
            int n = sc.nextInt();
            int matrix[][] = new int[m][n];
            System.out.println("Enter elements in matrix: ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int sum = diagonalSum(matrix);
            System.out.println("Diagonal sum = " + sum);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
