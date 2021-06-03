class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        horizontalCuts.push_back(0);
        horizontalCuts.push_back(h);
        sort(horizontalCuts.begin(), horizontalCuts.end());
        
        verticalCuts.push_back(0);
        verticalCuts.push_back(w);
        sort(verticalCuts.begin(), verticalCuts.end());
        
        int big_h = 0;
        int big_w = 0;
        
        for(vector<int>::iterator hrz = horizontalCuts.begin(); hrz != horizontalCuts.end()-1; hrz++){
            if(big_h < *(hrz+1) - *hrz){
                big_h = *(hrz+1) - *hrz;
            }
        }
        for(vector<int>::iterator vrt = verticalCuts.begin(); vrt != verticalCuts.end()-1; vrt++){
            if(big_w < *(vrt+1) - *vrt){
                big_w = *(vrt+1) - *vrt;
            }
        }
        
        long long result = (long long) big_h * (long long) big_w;
        if(result > INT_MAX){
            return (int) (result % (long long)(pow(10, 9) + 7));
        }
        else{
            return (int)result;
        }
    }
};