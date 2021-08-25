class Solution {
    public boolean judgeSquareSum(int c) {
        double limit = Math.sqrt(c/2);
        for(int a = (int)Math.sqrt(c); a >= limit; a--){
            int b = (int)Math.sqrt(c-a*a);
            if(c-a*a == b*b) return true;
        }
        return false;
    }
}