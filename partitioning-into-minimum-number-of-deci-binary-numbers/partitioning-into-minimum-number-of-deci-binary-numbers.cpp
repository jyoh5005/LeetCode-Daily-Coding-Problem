class Solution {
public:
    int minPartitions(string n) {
        int r = '0';
        for(string::iterator c = n.begin(); c != n.end(); c++){
            if(r < *c){
                r = *c;
            }
        }
        return r-'0';
    }
};