class Solution {
public:
    bool isIsomorphic(string s, string t) {
        map<char, char> m[2];
        for(int i = 0; i < s.size(); i++){
            if(m[0].find(s[i]) == m[0].end() && m[1].find(t[i]) == m[1].end()){
                m[0][s[i]] = t[i];
                m[1][t[i]] = s[i];
            }
            else if(m[0][s[i]] != t[i] || m[1][t[i]] != s[i]){
                return false;
            }
        }
        return true;
    }
};