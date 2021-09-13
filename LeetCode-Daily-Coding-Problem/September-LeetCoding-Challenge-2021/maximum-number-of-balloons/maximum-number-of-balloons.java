class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] alpabet = new int[26];
        for(char c : text.toCharArray()) alpabet[(int)c - 'a']++;
        int count = 0;
        for(;;count++){
            if(alpabet[1] == 0) return count;   // b
            if(alpabet[0] == 0) return count;   // a
            if(alpabet[11] <= 1) return count;  // l
            if(alpabet[14] <= 1) return count;  // o
            if(alpabet[13] == 0) return count;  // n
            
            alpabet[1]--;
            alpabet[0]--;
            alpabet[11] -= 2;
            alpabet[14] -= 2;
            alpabet[13]--;
        }
    }
}