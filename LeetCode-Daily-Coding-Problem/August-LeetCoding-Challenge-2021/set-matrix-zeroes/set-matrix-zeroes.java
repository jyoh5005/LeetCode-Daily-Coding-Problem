class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(matrix[r][c] == 0){
                    row[r] = true;
                    col[c] = true;
                }
            }
        }
        for(int r = 0; r < matrix.length; r++){
            if(row[r]){
                for(int c = 0; c < matrix[0].length; c++){
                    matrix[r][c] = 0;
                }
            }
        }
        for(int c = 0; c < matrix[0].length; c++){
            if(col[c]){
                for(int r = 0; r < matrix.length; r++){
                    matrix[r][c] = 0;
                }
            }
        }
        return;
    }
}