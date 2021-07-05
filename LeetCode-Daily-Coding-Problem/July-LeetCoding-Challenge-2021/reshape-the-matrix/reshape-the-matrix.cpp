class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
        if(mat.size() * mat[0].size() != r * c){
            return mat;
        }
        vector<vector<int>> result;
        int x = 0;
        int y = 0;
        for(int i = 0; i < r; i++){
            vector<int> temp;
            for(int j = 0; j < c; j++){
                temp.push_back(mat[x][y++]);
                if(y == mat[0].size()){
                    x++;
                    y = 0;
                }
            }
            result.push_back(temp);
        }
        return result;
    }
};