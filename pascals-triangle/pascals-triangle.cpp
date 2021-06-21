class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> result;
        vector<int> temp;
        temp.push_back(1);
        result.push_back(temp);
        temp.clear();
        for(int i = 0; i < numRows-1; i++){
            temp.push_back(1);
            for(int j = 0; j < i; j++){
                temp.push_back(result[i][j] + result[i][j+1]);
            }
            temp.push_back(1);
            result.push_back(temp);
            temp.clear();
        }
        return result;
    }
};