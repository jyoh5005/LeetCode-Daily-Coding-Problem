class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        sort(boxTypes.begin(), boxTypes.end(), [](vector<int> b1, vector<int> b2)->bool{return b1[1] > b2[1];});
        int result = 0;
        for(int i = 0; i < boxTypes.size(); i++){
            if(boxTypes[i][0] > truckSize){
                result += truckSize * boxTypes[i][1];
                break;
            }
            else{
                result += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }
        }
        return result;
    }
};