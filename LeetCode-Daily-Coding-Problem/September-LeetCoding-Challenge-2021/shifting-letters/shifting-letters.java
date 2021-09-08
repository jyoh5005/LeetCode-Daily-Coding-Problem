class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder result = new StringBuilder();
        int sft = 0;
        for(int i = shifts.length-1; i >= 0; i--){
            sft = (sft + shifts[i]) % 26;
            result.append((char)((((int) s.charAt(i) - 'a' + sft) % 26) + 'a'));
        }
        return result.reverse().toString();
    }
}