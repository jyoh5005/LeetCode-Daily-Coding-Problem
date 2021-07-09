class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int return_val = 0;
        int dp[nums.size()];
        for(int i = nums.size()-1; i >= 0; i--){
            int result = 0;
            for(int j = i+1; j < nums.size(); j++){
                if(nums[i] < nums[j] && result < dp[j]){
                    result = dp[j];
                }
            }
            dp[i] = result + 1;
            if(return_val < dp[i]){
                return_val = dp[i];
            }
        }
        return return_val;
    }
};
