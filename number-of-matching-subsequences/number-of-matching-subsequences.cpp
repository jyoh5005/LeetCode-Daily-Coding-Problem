class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        /*
        for(int i = 0; i < words.size(); i++){
            int c = 0;
            for(int j = 0; j < s.size(); j++){
                if(words[i][c] == s[j]){
                    c++;
                }
            }
            if(words[i].size() == c){
                cout << words[i] << endl;
            }
        }
        return 0;*/
        
        int result = 0;
        map<string, pair<int, int>> str_map;
        stack<string> map_erase;
        for(int i = 0; i < words.size(); i++){
            str_map.insert(make_pair(words[i], make_pair(0, 0)));
            str_map[words[i]].first++;
        }
        for(string::iterator c = s.begin(); c != s.end(); c++){
            //cout << *c << endl;
            if(str_map.size() == 0){
                return result;
            }
            for(map<string, pair<int, int>>::iterator it = str_map.begin(); it != str_map.end(); it++){
                //cout << "string = " << it->first << ", char_idx = " << it->second.second;
                //cout << ", char = " << it->first[it->second.second] << endl;
                if(it->first[it->second.second] == *c){
                    if(++it->second.second == it->first.size()){
                        //cout << "ERASE!, result += " <<  it->second.first << endl;
                        result += it->second.first;
                        //str_map.erase(it);
                        map_erase.push(it->first);
                    }
                }
            }
            while(!map_erase.empty()){
                //cout << map_erase.top() << endl;
                str_map.erase(map_erase.top());
                map_erase.pop();
            }
        }
        return result;
    }
};