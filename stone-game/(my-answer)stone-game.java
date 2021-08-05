class Solution {
    public boolean stoneGame(int[] piles) {
        int begin = 0;
        int end = piles.length-1;
        int sum = 0;
        boolean change_player = false;
        while(begin <= end){
            if(change_player){
                if(piles[begin] > piles[end]) sum -= piles[begin++];
                else sum -= piles[end--];
            }
            else{
                if(piles[begin] > piles[end]) sum += piles[begin++];
                else sum += piles[end--];
            }
        }
        return sum > 0;
    }
}