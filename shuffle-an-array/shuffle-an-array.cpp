class Solution {
public:
    vector<int> a;
    vector<int> b;
    Solution(vector<int>& nums) {
        a = nums;
        b = vector<int>(nums);
    }
    
    /** Resets the array to its original configuration and return it. */
    vector<int> reset() {
        return a;
    }
    
    /** Returns a random shuffling of the array. */
    vector<int> shuffle() {
        random_device rd;
        mt19937 gen(rd());
        std::shuffle(b.begin(), b.end(), gen);
        return b;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(nums);
 * vector<int> param_1 = obj->reset();
 * vector<int> param_2 = obj->shuffle();
 */