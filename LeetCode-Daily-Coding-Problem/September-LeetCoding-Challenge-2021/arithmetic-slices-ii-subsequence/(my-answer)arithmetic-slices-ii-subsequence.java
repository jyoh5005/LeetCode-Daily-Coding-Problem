class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        else if(nums.length == 3){
            if((long)nums[0]+(long)nums[2] == (((long)nums[1])<<1)) return 1;
            else return 0;
        }
        else return result(nums);
    }
    private int result(int[] nums){
        int[][] dp = new int[nums.length][nums.length]; // set zero initial
        int count = 0;
        for(int i = nums.length-3; i >= 0; i--){
            for(int j = nums.length-2; j >= i+1; j--){
                count = 0;
                for(int k = nums.length-1; k >= j+1; k--){
                    if((long)nums[i]+(long)nums[k] == (((long)nums[j])<<1)){
                        count += dp[j][k] + 1;
                    }
                }
                dp[i][j] = count;
            }
        }
        // outing(dp);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                count += dp[i][j];
            }
        }
        count -= dp[0][1];
        return count;
    }
    private void outing(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                System.out.print(dp[i][j]);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
}