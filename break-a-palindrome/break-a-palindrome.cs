public class Solution {
    public string BreakPalindrome(string palindrome) {
        if(palindrome.Length == 1) return "";
        char[] arr = palindrome.ToCharArray();
        int i;
        for(i = 0; i < palindrome.Length/2; i++){
            if(arr[i] != 'a'){
                arr[i] = 'a';
                return new String(arr);
            }
        }
        if(palindrome.Length % 2 == 1) i++;
        for(; i < palindrome.Length; i++){
            if(arr[i] != 'a'){
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[palindrome.Length-1]++;
        return new String(arr);
    }
}