//LEETCODE 304
/*Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix 
inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
You must design an algorithm where sumRegion works on O(1) time complexity.*/

class NumMatrix {
    int[][]prefix;
    public NumMatrix(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;

        prefix=new int[r][c];

        prefix[0][0]=matrix[0][0];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){

                int A = matrix[i][j];
                int B = j-1 >= 0 ? prefix[i][j-1] : 0;
                int C = i-1 >= 0 ? prefix[i-1][j] : 0;
                int D = i-1 >= 0 && j-1 >= 0 ? prefix[i-1][j-1] : 0;

                prefix[i][j] = (A + B + C - D);
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int A = prefix[row2][col2];
        int B = col1-1 >= 0 ? prefix[row2][col1-1] : 0;
        int C = row1-1 >= 0 ? prefix[row1-1][col2] : 0;
        int D = row1-1 >= 0 && col1-1 >= 0 ? prefix[row1-1][col1-1] : 0;

        return (A - B - C + D);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
