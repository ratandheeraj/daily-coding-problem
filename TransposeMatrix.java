// Transpose Matrix [Easy]

// Question:
// Given a 2D integer array square matrix, return the transpose of matrix.

// The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[1,4,7],[2,5,8],[3,6,9]]


// Answer:
// Here we need to turn rows into columns, and columns into rows.

//   1       2       3
//   4       5       6
//   7       8       9

// should become

//   1       4       7
//   2       5       8
//   3       6       9

// if we look at this square matrix, diagonal elements, does not change, 1,5,9 need not be changed
// 4 will be replaced by 2 and 2 will be replaced by 4 and so on.

// We need not traverse the entire matrix, we can only traverse the elements below the diagonal and swap the numbers 
// to get the transpose of the matrix.


public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        if(matrix.length < 1) return null;
        
        int n = matrix.length;
        int temp;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                if(i == j){
                    continue;
                }
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        return matrix;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        matrix = transpose(matrix);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
}


// Time Complexity: O( (n*(n+1))/2 )
// Space Complexity: O(1)