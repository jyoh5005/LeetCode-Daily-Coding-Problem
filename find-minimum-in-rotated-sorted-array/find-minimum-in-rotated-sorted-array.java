class Solution {
    public int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length-1]) return nums[0];
        return nums[findMinInner(nums, 0, nums.length-1)];
    }
    private int findMinInner(int[] nums, int s, int e){
        if(s > e) return -1;
        int mid = (s+e+1)/2;
        if(mid == 0) return 0;
        if(nums[mid-1] > nums[mid]) return mid;
        int result;
        result = findMinInner(nums, mid+1, e);
        if(result >= 0) return result;
        result = findMinInner(nums, s, mid-1);
        if(result >= 0) return result;
        return -1;
    }
}