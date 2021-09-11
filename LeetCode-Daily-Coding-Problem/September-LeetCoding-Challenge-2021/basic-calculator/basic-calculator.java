class Solution {
    int i;
    public int calculate(String s) {
        i = -1;
        return cal(s);
    }
    private int cal(String s){
        int result = 0;
        int num = 0;
        char op = '+';
        for(i++; i < s.length(); i++){
            switch (s.charAt(i)){
                case '+':
                    result += (44-(int)op) * num;
                    num = 0;
                    op = '+';
                    break;
                case '-':
                    result += (44-(int)op) * num;
                    num = 0;
                    op = '-';
                    break;
                case '(':
                    num = cal(s);
                    break;
                case ')':
                    result += (44-(int)op) * num;
                    return result;
                case ' ':
                    break;
                default:
                    num *= 10;
                    num += s.charAt(i)-'0';
            }
        }
        result += (44-(int)op) * num;
        return result;
    }
}