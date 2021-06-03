class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int result = 0;
        int sum = 0;
        vector<int>::iterator front;
        vector<int>::iterator back;
        for(front = cardPoints.begin(); front-k != cardPoints.begin(); front++){
            sum += *front;
        }
        result = sum;
        front--;
        for(back = cardPoints.end(); front+1 != cardPoints.begin(); front--){
            back--;
            sum += *back - *front;
            if(sum > result){
                result = sum;
            }
        }
        return result;
    }
};