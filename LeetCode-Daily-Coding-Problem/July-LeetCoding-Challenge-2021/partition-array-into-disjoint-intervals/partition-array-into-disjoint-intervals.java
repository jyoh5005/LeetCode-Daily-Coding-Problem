class Solution {
    public int partitionDisjoint(int[] nums) {
        int fidx = 0;
        int fmax_num = nums[0];
        int lmax_num = Math.max(nums[0], nums[1]);
        for(int lidx = 1; lidx < nums.length; lidx++){
            if(fmax_num > nums[lidx]){
                fidx = lidx;
                fmax_num = lmax_num;
            }
            if(lmax_num < nums[lidx]){
                lmax_num = nums[lidx];
            }
        }
        return fidx+1;
    }
}