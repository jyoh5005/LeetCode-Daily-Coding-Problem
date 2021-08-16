class NumArray {
    int[] num;
    public NumArray(int[] nums) {
        num = nums;
    }
    
    public int sumRange(int left, int right) {
        int result = 0;
        for(int i = left; i <= right; i++) result += num[i];
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */