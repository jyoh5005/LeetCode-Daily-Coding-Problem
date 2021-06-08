class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int size = cost.size();
        int c[size+1];
        c[0] = 0;
        c[1] = cost[size-1];
        cout << c[0] << endl << c[1] << endl;
        for(int i = 2; i < size+1; i++){
            c[i] = cost[size-i] + min(c[i-1], c[i-2]);
        }
        return min(c[size], c[size-1]);
    }
};