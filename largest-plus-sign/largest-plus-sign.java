class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if(mines.length == n * n) return 0;
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) grid[i][j] = 1;
        for(int[] mine : mines) grid[mine[0]][mine[1]] = 0;
        int max = 1;
        for(int i = 1; 2 * i < n; i++){
            for(int x = i; x < n-i; x++){
                for(int y = i; y < n-i; y++){
                    if(grid[x][y] < i) continue;
                    if(grid[x-i][y] == 0) continue;
                    if(grid[x+i][y] == 0) continue;
                    if(grid[x][y-i] == 0) continue;
                    if(grid[x][y+i] == 0) continue;
                    grid[x][y] = i+1;
                    max = i+1;
                }
            }
        }
        return max;
    }
    private void outing(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }
}