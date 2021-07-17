class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> result;
        for(int a = 0; a < nums.size(); a++){
            for(int b = a+1; b < nums.size(); b++){
                for(int c = b+1; c < nums.size(); c++){
                    for(int d = c+1; d < nums.size(); d++){
                        if(target == nums[a] + nums[b] + nums[c] + nums[d]){
                            vector<int> temp;
                            temp.push_back(nums[a]);
                            temp.push_back(nums[b]);
                            temp.push_back(nums[c]);
                            temp.push_back(nums[d]);
                            sort(temp.begin(), temp.end());
                            if(find(result.begin(), result.end(), temp) == result.end()){
                                result.push_back(temp);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
};