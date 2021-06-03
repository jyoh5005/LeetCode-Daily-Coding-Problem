class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        
        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        
        obstacleGrid[0][0]--;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] != 1){
                    if(i > 0 && obstacleGrid[i-1][j] != 1){
                        obstacleGrid[i][j] += obstacleGrid[i-1][j];
                    }
                    if(j > 0 && obstacleGrid[i][j-1] != 1){
                        obstacleGrid[i][j] += obstacleGrid[i][j-1];
                    }
                }
            }
        }
        return -obstacleGrid[m-1][n-1];
    }
};