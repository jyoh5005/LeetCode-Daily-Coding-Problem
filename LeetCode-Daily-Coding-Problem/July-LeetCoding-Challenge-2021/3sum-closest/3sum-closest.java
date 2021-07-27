class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int return_value = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if(temp > target) end--;
                else if(temp < target) start++;
                else return target;
                if(Math.abs(return_value - target) > Math.abs(temp - target)) {
                    return_value = temp;
                }
            }
        }
        return return_value;
    }
}
