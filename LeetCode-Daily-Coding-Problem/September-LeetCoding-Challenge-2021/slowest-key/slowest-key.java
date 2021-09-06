class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int num = releaseTimes[0];
        char result = keysPressed.charAt(0);
        for(int i = 1; i < releaseTimes.length; i++){
            int temp = releaseTimes[i]-releaseTimes[i-1];
            if(temp > num){
                result = keysPressed.charAt(i);
                num = temp;
            }
            else if(temp == num){
                if(keysPressed.charAt(i) > result){
                    result = keysPressed.charAt(i);
                }
            }
        }
        return result;
    }
}