// <- if you remove, you can see how this code runing
class Solution {
public:
    int candy(vector<int>& ratings) {
        if(ratings.size() == 1){
            return 1;
        }
        if(ratings.size() == 2){
            if(ratings[0] == ratings[1]){
                return 2;
            }
            else{
                return 3;
            }
        }
        int result = 0;
        int count = 1;
        stack<int> re_op;
        stack<int> bigest[2];
        
        // case 1: ratings[0] and ratings[0] <= ratings[1]
        if(ratings[0] <= ratings[1]){
            result++;
            // cout << '1' << endl;
        }
        
        // case 2: ratings[1] ~ ratings[ratings.size()-2]
        for(int i = 1; i < ratings.size()-1; i++){
            if(ratings[i] > ratings[i+1]){
                if(ratings[i-1] < ratings[i]){
                    bigest[0].push(i);
                    bigest[1].push(count);
                    // cout << "input bigest[0] = " << bigest[0].top();
                    // cout << ", bigest[1] = " << bigest[1].top() << endl;
                }
                else{
                    re_op.push(i);
                    // cout << "input re_op = " << re_op.top() << endl;
                }
            }
            else if(ratings[i-1] < ratings[i]){
                result += ++count;
                // cout << count << endl;
            }
            else{
                result++;
                count = 1;
                // cout << '1' << endl;
            }
        }
        
        // case 3: ratings[ratings.size()-1]
        if(ratings[ratings.size()-2] < ratings[ratings.size()-1]){
            result += ++count;
            // cout << count << endl;
        }
        else{
            result++;
            // cout << '1' << endl;
        }
        
        // done?
        if(re_op.empty() && bigest[0].empty()){
            if(ratings[0] > ratings[1]){
                result += 2;
                // cout << count << endl;
            }
            return result;
        }
        
        // reverse operate
        count = 1;
        // cout << "check re_op && bigest\n";
        if(!re_op.empty() && !bigest[0].empty()){
            while(!bigest[0].empty()){
                int re_op_idx = re_op.top();
                int bigest_idx = bigest[0].top();
                if(re_op_idx > bigest_idx){
                    re_op.pop();
                    result += ++count;
                    // cout << count << endl;
                    if(re_op.empty()){
                        // cout << "empty\n";
                        if(re_op_idx-1 != bigest_idx){
                            count = 1;
                        }
                        break;
                    }
                    else if(re_op_idx-1 != re_op.top() && re_op_idx-1 != bigest_idx){
                        count = 1;
                    }
                }
                else{
                    // cout << max(bigest[1].top(), count)+1 << endl;
                    result += max(bigest[1].top(), count)+1;
                    bigest[0].pop();
                    bigest[1].pop();
                    count = 1;
                }
            }
        }
        // cout << "check bigest\n";
        while(!bigest[0].empty()){
            // cout << max(bigest[1].top(), count)+1 << endl;
            result += max(bigest[1].top(), count)+1;
            bigest[0].pop();
            bigest[1].pop();
            count = 1;
        }
        // cout << "check re_op\n";
        if(!re_op.empty()){
            while(true){
                int re_op_idx = re_op.top();
                re_op.pop();
                result += ++count;
                // cout << count << endl;
                if(re_op.empty()){
                    if(ratings[0] > ratings[1] && ratings[1] > ratings[2]){
                        result += ++count;
                        return result;
                    }
                    count = 1;
                    break;
                }
                else if(re_op_idx-1 != re_op.top()){
                    count = 1;
                }
            }
        }
        
        if(ratings[0] > ratings[1]){
            // cout << "Asdfsdf\n";
            result += ++count;
            // cout << count << endl;
        }
        return result;
    }
};
/*
ITERATING ratings[0] => ratings[size-1]
[a]<[b]>[c]
b = max(a, c)+1 bigest(b) -> stack
[a]>[b]<[c]
b = 1
[a]<[b]<[c]
b = a+1
[a]>[b]>[c]
b = c+1, reverse_operate(b) -> stack
[a]=[b]<[c]
b = 1
[a]=[b]>[c]
b = c+1, reverse_operate(b) -> stack
[a]<[b]=[c]
b = a+1
[a]>[b]=[c]
b = 1
[a]=[b]=[c]
b = 1
*/