class Solution {
public:
    vector<int> threeEqualParts(vector<int>& arr) {
        vector<int> result;
        int one_count = 0;
        for(int x = 0; x < arr.size(); x++){
            if(arr[x] == 1){
                one_count++;
            }
        }
        
        if(one_count % 3 != 0){
            result.push_back(-1);
            result.push_back(-1);
            return result;
        }
        if(one_count == 0){
            result.push_back(0);
            result.push_back(arr.size()-1);
            return result;
        }
        
        one_count /= 3;
        int count = 0;
        bool get_idx = false;
        for(int x = 0; x < arr.size(); x++){
            if(arr[x] == 1){
                count++;
            }
            if(count == one_count){
                result.push_back(x);
                count = 0;
                if(get_idx){
                    break;
                }
                else{
                    get_idx = true;
                }
            }
        }
        
        count = arr.size()-1;
        while(arr[count--] == 0){
            if(arr[result.front()+1] != 0 || arr[result.back()+1] != 0){
                result.front() = -1;
                result.back() = -1;
                return result;
            }
            result.front()++;
            result.back()++;
        }
        result.back()++;
        
        count = result.front();
        one_count = result.back()-1;
        int two_count = arr.size()-1;
        while(count >= 0 && one_count > result.front() && two_count >= result.back()){
            int temp1 = arr[count];
            int temp2 = arr[count--];
            temp1 &= arr[one_count];
            temp2 |= arr[one_count--];
            temp1 &= arr[two_count];
            temp2 |= arr[two_count--];
            if(temp1 == 0 && temp2 == 1){
                result.front() = -1;
                result.back() = -1;
                return result;
            }
        }
        return result;
    }
};