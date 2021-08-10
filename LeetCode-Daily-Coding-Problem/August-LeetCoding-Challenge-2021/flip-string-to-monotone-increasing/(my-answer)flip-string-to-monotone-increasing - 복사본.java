class Solution {
    public int minFlipsMonoIncr(String s) {
        int one_count = 0;
        int zero_count = 0;
        for(char c : s.toCharArray()) if(c == '0') zero_count++;
        int result = zero_count;
        for(char c : s.toCharArray()){
            if(c == '1') one_count++;
            else zero_count--;
            if(result > one_count+zero_count) result = one_count+zero_count;
        }
        return result;
    }
}