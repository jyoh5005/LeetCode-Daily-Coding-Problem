class Solution {
    private char[] arr;
    public boolean isValidSerialization(String preorder) {
        arr = preorder.toCharArray();
        if(arr.length == 1){
            if(arr[0] == '#') return true;
            else return false;
        }
        if(arr[0] == '#') return false;
        if(arr[arr.length-1] != '#') return false;
        if(check(0) == arr.length-1) return true;
        return false;
    }
    private int check(int i){
        while(arr[i++] != ',') if(arr.length == i) return i;
        if(arr[i] != '#') i = check(i);
        while(arr[i++] != ',') if(arr.length == i) return i;
        if(arr[i] != '#') i = check(i);
        return i;
    }
}