class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        int result = 0;
        int dp[nums1.size()][nums2.size()];
        for(int i = 0; i < nums1.size(); i++){
            for(int j = 0; j < nums2.size(); j++){
                if(nums1[i] != nums2[j]){
                    dp[i][j] = 0;
                }
                else{
                    if(i == 0){
                        dp[i][j] = 1;
                    }
                    else if(j == 0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                if(result < dp[i][j]){
                    result = dp[i][j];
                }
            }
        }
        return result;
    }
};