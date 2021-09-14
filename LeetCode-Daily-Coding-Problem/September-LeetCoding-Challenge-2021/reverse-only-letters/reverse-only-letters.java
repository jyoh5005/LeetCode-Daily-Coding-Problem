class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i <= j){
            boolean swap = true;
            if(!('a' <= arr[i] && arr[i] <= 'z' || 'A' <= arr[i] && arr[i] <= 'Z')){
                swap = false;
                i++;
            }
            if(!('a' <= arr[j] && arr[j] <= 'z' || 'A' <= arr[j] && arr[j] <= 'Z')){
                swap = false;
                j--;    
            }
            if(swap){
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}