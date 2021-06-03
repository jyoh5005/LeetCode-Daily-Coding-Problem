class Solution {
public:
    int maxProduct(vector<string>& words) {
        int result = 0;
        int alphabet[26];
        bool is_not_share;
        
        vector<string>::iterator str1;
        vector<string>::iterator str2;
        vector<string>::iterator end = words.end();
        string::iterator c;
        
        for(str1 = words.begin(); str1 != end; str1++){
            for(int i = 0; i < 26; i++){
                alphabet[i] = 0;
            }
            for(c = str1->begin(); c != str1->end(); c++){
                alphabet[*c-'a']++;
            }
            for(str2 = str1 + 1; str2 != end; str2++){
                is_not_share = true;
                for(c = str2->begin(); c != str2->end(); c++){
                    if(alphabet[*c-'a'] != 0){
                        is_not_share = false;
                        break;
                    }
                }
                if(is_not_share && result < str1->size() * str2->size()){
                    result = str1->size() * str2->size();
                }
            }
        }
        
        return result;
    }
};