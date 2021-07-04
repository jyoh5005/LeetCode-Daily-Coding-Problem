class Solution {
public:
    int countVowelPermutation(int n) {
        long long result = 0;
        long long* x = new long long[5];
        long long* y = new long long[5];
        for(int i = 0; i < 5; i++){
            x[i] = 1;
        }
        for(int i = 1; i < n; i++){
            //a == 0 e == 1 i == 2 o == 3 u == 4
            y[0] = (x[1] + x[2] + x[4]) % (long long)(pow(10, 9) + 7);
            y[1] = (x[0] + x[2]) % (long long)(pow(10, 9) + 7);
            y[2] = (x[1] + x[3]) % (long long)(pow(10, 9) + 7);
            y[3] = x[2] % (long long)(pow(10, 9) + 7);
            y[4] = (x[2] + x[3]) % (long long)(pow(10, 9) + 7);
            swap(x, y);
        }
        for(int i = 0; i < 5; i++){
            result += x[i];
        }
        result %= (long long)(pow(10, 9) + 7);
        return (int) result;
    }
};