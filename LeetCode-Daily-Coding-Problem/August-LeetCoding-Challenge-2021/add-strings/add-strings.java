class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()) return addStr(num1.toCharArray(), num2.toCharArray());
        else return addStr(num2.toCharArray(), num1.toCharArray());
    }
    private String addStr(char[] num1, char[] num2){
        StringBuilder result = new StringBuilder();
        int n = 0;
        int i, j;
        for(i = num1.length-1, j = num2.length-1; i >= 0; i--, j--){
            n += num1[i] + num2[j] - 2 * '0';
            if(n > 9){
                result.append(n-10);
                n = 1;
            }
            else{
                result.append(n);
                n = 0;
            }
        }
        if(n == 1){
            for(i = j; i >= 0; i--){
                if(num2[i] == '9') num2[i] = '0';
                else{
                    num2[i] += 1;
                    n = 0;
                    break;
                }
            }
        }
        for(; j >= 0; j--) result.append(num2[j]);
        if(n == 1) result.append(1);
        return result.reverse().toString();
    }
}