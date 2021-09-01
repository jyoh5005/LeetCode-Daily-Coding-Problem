class Solution {
    public int arrayNesting(int[] nums) {
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == -1) continue;
            int idx = i;
            int count = 0;
            int temp;
            do{
                temp = nums[idx];
                nums[idx] = -1;
                idx = temp;
                count++;
            }while(i != idx && idx != -1);
            if(result < count) result = count;
        }
        return result;
    }
}