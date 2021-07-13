class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int begin_idx = 0;
        int end_idx = nums.size()-1;
        while(begin_idx < end_idx){
            int mean_idx = (begin_idx + end_idx) / 2;
            if(nums[mean_idx] > nums[mean_idx+1]){
                end_idx = mean_idx;
            }
            else{
                begin_idx = mean_idx + 1;
            }
        }
        return begin_idx;
    }
};