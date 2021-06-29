class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int i = 0;
        int j = 0;
        for (; i < nums.size(); i++) {
            if (nums[i] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[j] == 0) {
                    k++;
                }
                j++;
            }
        }
        return i - j;
    }
};