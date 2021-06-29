class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        vector<int> one[2];
        bool is_zero = true;
        for(int i = 0; i < nums.size(); i++){
            if(is_zero && nums[i] == 1){
                is_zero = false;
                one[0].push_back(i);
            }
            else if(!is_zero && nums[i] == 0){
                is_zero = true;
                one[1].push_back(i-1);
            }
        }
        if(!is_zero){
            one[1].push_back(nums.size()-1);
        }
        // for(int i = 0; i < one[0].size(); i++){
        //     cout << "i = " << i << ", one[0] = " << one[0][i] << ", one[1] = " << one[1][i] << endl;
        // }
        int result = 0;
        int temp_result;
        int temp_k;
        for(int i = 0; i < one[0].size(); i++){
            temp_result = one[1][i] - one[0][i] + 1;
            temp_k = k;
            // cout << "i = " << i << ", init result = " << temp_result << endl;
            for(int j = i + 1; j < one[0].size(); j++){
                // cout << "j = " << j << ", gap = " << one[0][j] - one[1][j-1] - 1 << ", k = " << temp_k << endl;
                if(one[0][j] - one[1][j-1] - 1 > temp_k){
                    temp_result += temp_k;
                    temp_k = 0;
                    break;
                }
                else{
                    // temp_result += (one[0][i] - one[1][i-1] - 1) + one[1][i] - one[0][i] + 1);
                    temp_result += one[1][j] - one[1][j-1];
                    temp_k -= one[0][j] - one[1][j-1] - 1;
                }
                // cout << "temp result = " << temp_result << ", k = " << temp_k << endl;
            }
            // cout << "temp result = " << temp_result << ", k = " << temp_k << endl;
            if(temp_k != 0){
                int add_empty = 0;
                if(i == 0) add_empty += one[0][0];
                else add_empty += one[0][i] - one[1][i-1] - 1;
                
                if(i == one[0].size()-1) add_empty += nums.size() - 1 - one[1][i];
                else add_empty += one[0][i+1] - one[1][i] - 1;
                
                if(add_empty >= temp_k) temp_result += temp_k;
                else temp_result += add_empty;
            }
            // cout << endl;
            // cout << "temp result = " << temp_result << ", k = " << temp_k << endl;
            // cout << "result = " << result << ", temp result = " << temp_result << endl << endl;
            if(result < temp_result){
                result = temp_result;
            }
        }
        // cout << one[1][one[1].size()-1] << ' ' << nums.size()-1;
        return result;
    }
};