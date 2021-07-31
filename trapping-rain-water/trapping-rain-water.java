class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int max_idx = 0;
        int max_height = height[0];
        for(int i = max_idx+1; i < height.length; i++){
            if(max_height < height[i]){
                max_height = height[i];
                max_idx = i;
            }
        }
        
        int result = 0;
        int temp = 0;
        
        max_height = height[0];
        for(int i = 0; i <= max_idx; i++){
            if(max_height > height[i]){
                temp += max_height - height[i];
                continue;
            }
            if(max_height < height[i]) max_height = height[i];
            result += temp;
            temp = 0;
        }
        
        max_height = height[height.length-1];
        for(int i = height.length-1; i >= max_idx; i--){
            if(max_height > height[i]){
                temp += max_height - height[i];
                continue;
            }
            if(max_height < height[i]) max_height = height[i];
            result += temp;
            temp = 0;
        }
        
        return result;
    }
}