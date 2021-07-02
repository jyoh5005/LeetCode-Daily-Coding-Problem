class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        sort(arr.begin(), arr.end(),
             [&x](int a, int b){
                if(abs(a-x) == abs(b-x)){
                    return a < b;
                }
                return abs(a-x) < abs(b-x);
             }
        );
        arr.resize(k);
        sort(arr.begin(), arr.end());
        return arr;
    }
};