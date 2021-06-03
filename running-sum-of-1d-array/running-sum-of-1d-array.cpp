class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        for(vector<int>::iterator it = nums.begin()+1; it != nums.end(); it++){
            *it += *(it-1);
        }
        return nums;
    }
};