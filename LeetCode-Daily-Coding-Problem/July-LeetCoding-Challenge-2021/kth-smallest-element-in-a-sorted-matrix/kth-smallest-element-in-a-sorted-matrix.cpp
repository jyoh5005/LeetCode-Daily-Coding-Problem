class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        vector<int> result;
        for(vector<vector<int>>::iterator i = matrix.begin(); i != matrix.end(); i++){
            for(vector<int>::iterator j = i->begin(); j != i->end(); j++){
                result.push_back(*j);
            }
        }
        sort(result.begin(), result.end());
        return result[k-1];
    }
};