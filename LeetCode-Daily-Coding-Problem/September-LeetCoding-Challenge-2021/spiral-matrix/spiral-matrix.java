class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>(rowSize * colSize);
        for(int rotate = 0; (rotate<<1) < rowSize && (rotate<<1) < colSize; rotate++){
            if((rotate<<1) == rowSize-1){
                for(int i = rotate; i < colSize-rotate; i++){
                    result.add(matrix[rotate][i]);
                }
                return result;
            }
            if((rotate<<1) == colSize-1){
                for(int i = rotate; i < rowSize-rotate; i++){
                    result.add(matrix[i][rotate]);
                }
                return result;
            }
            for(int i = rotate; i < colSize-rotate-1; i++){
                result.add(matrix[rotate][i]);
            }
            for(int i = rotate; i < rowSize-rotate-1; i++){
                result.add(matrix[i][colSize-rotate-1]);
            }
            for(int i = colSize-rotate-1; i > rotate; i--){
                result.add(matrix[rowSize-rotate-1][i]);
            }
            for(int i = rowSize-rotate-1; i > rotate; i--){
                result.add(matrix[i][rotate]);
            }
        }
        return result;
    }
}