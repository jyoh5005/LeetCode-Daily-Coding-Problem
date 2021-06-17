class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        int result = 0;
        int count = 0;
        int not_least_count = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] > right){
                count = 0;
                not_least_count = 0;
                continue;
            }
            else if(nums[i] < left){
                result -= ++not_least_count;
            }
            else{
                not_least_count = 0;
            }
            result += ++count;
        }
        return result;
    }
};