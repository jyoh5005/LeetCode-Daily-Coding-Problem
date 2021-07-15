class Solution {
public:
    string customSortString(string order, string str) {
        int alpabet[26] = {0};
        for(int i = 0; i < order.size(); i++){
            alpabet[order[i]-'a'] = i;
        }
        sort(str.begin(), str.end(), 
             [&alpabet](char& cmp1, char& cmp2){return alpabet[cmp1-'a'] < alpabet[cmp2-'a'];});
        return str;
    }
};