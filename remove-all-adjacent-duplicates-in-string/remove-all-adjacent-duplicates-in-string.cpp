class Solution {
public:
    string removeDuplicates(string s) {
        int idx = 0;
        while(idx != s.size()){
            for(idx = 0; idx < s.size(); idx++){
                if(s[idx] == s[idx+1]){
                    int erase = 1;
                    while(true){
                        if(idx - erase  < 0){
                            break;
                        }
                        if(idx +1 + erase >= s.size()){
                            break;
                        }
                        if(s[idx - erase] != s[idx +1 + erase]){
                            break;
                        }
                        erase++;
                    }
                    erase--;
                    s.replace(idx - erase, 2*(erase+1), "");
                    break;
                }
            }
        }
        return s;
    }
};