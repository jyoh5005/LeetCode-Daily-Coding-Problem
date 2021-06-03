class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> num;
        int t1, t2;
        for(vector<string>::iterator str = tokens.begin(); str != tokens.end(); str++){
            if(str->size() == 1){
                switch((*str)[0]){
                    case '+':
                        t1 = num.top();
                        num.pop();
                        t2 = num.top();
                        num.pop();
                        num.push(t2 + t1);
                        break;
                    case '-':
                        t1 = num.top();
                        num.pop();
                        t2 = num.top();
                        num.pop();
                        num.push(t2 - t1);
                        break;
                    case '*':
                        t1 = num.top();
                        num.pop();
                        t2 = num.top();
                        num.pop();
                        num.push(t2 * t1);
                        break;
                    case '/':
                        t1 = num.top();
                        num.pop();
                        t2 = num.top();
                        num.pop();
                        num.push(t2 / t1);
                        break;
                    default:
                        num.push(stoi(*str));
                }
            }
            else{
                num.push(stoi(*str));
            }
        }
        return num.top();
    }
};