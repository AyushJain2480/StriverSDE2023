/// O(M * N) extra space
import java.io.*;
import java.util.* ;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int matrix[][] = new int[rows][cols];
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    matrix[i][j] = sc.nextInt(); 
                }
            }
            System.out.println(Arrays.toString(matrix));
            setZeros(matrix);
        }
    }
    public static void setZeros(int matrix[][]) {
       int rows = matrix.length; 
       int cols = matrix[0].length;
       boolean[] zeroRows = new boolean[rows];
       boolean[] zeroCols = new boolean[cols];
       for(int row = 0; row < rows; row++){
           for(int col = 0; col < cols; col++){
               if(matrix[row][col] == 0){
                   zeroRows[row] = true;
                   zeroCols[col] = true;
               }
           }
       }
       for(int i = 0; i < rows; i++){
          if(zeroRows[i]){ 
            for(int j = 0; j < cols; j++){
                matrix[i][j] = 0;
            }
          }
       }
       for(int j = 0; j < cols; j++){
           if(zeroCols[j]){
             for(int i = 0; i < rows; i++){
               matrix[i][j] = 0;
             }
           }
       }
    }
}

// With constant space 
import java.io.*;
import java.util.* ;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int matrix[][] = new int[rows][cols];
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    matrix[i][j] = sc.nextInt(); 
                }
            }
            System.out.println(Arrays.toString(matrix));
            setZeros(matrix);
        }
    }
    public static void setZeros(int matrix[][]) {
       int rows = matrix.length; 
       int cols = matrix[0].length;
       boolean firstRowZero = false;
       boolean firstColZero = false;
        // Check if the first row needs to be zeroed
       for(int row = 0; row < rows; row++){
           if(matrix[row][0] == 0){
               firstColZero = true;
           }
       }
         // Check if the first column needs to be zeroed
       for(int col = 0; col < cols; col++){
           if(matrix[0][col] == 0){
               firstRowZero = true;
           }
       }
         // Mark rows and columns (except first row and first column) to be zeroed
       for(int row = 1; row < rows; row++){
           for(int col = 1; col < cols; col++){
               if(matrix[row][col] == 0){
                   matrix[row][0] = 0; // Mark the first column
                   matrix[0][col] = 0;  // Mark the first row
               }
           }
       }
        // Set rows (except first row) to zero
       for(int i = 1; i < rows; i++){
          if(matrix[i][0] == 0){
              for(int col = 1; col < cols; col++){
                  matrix[i][col] = 0;
              }
          }
       }
       // Set columns (except first column) to zero
       for(int j = 1; j < cols; j++){
          if(matrix[0][j] == 0){
              for(int row = 1; row < rows; row++){
                  matrix[row][j] = 0;
              }
          }
       }
       
    // Set first row to zero if necessary
       if(firstRowZero){
         Arrays.fill(matrix[0],0);
       }

    // Set first column to zero if necessary
       if(firstColZero){
          for(int row = 0; row < rows; row++){
              matrix[row][0] = 0;
          }
       }
    }
}
