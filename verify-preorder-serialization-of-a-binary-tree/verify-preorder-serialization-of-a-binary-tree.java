class Solution {
    private char[] arr;
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 1){
            if(preorder.charAt(0) == '#') return true;
            else return false;
        }
        if(preorder.charAt(0) == '#') return false;
        if(preorder.charAt(preorder.length()-1) != '#') return false;
        arr = preorder.toCharArray();
        if(check(0) == preorder.length()-1) return true;
        return false;
    }
    private int check(int i){
        while(arr[i++] != ',') if(arr.length == i) return i;
        System.out.println(arr[i]);
        if(arr[i] != '#') i = check(i);
        while(arr[i++] != ',') if(arr.length == i) return i;
        System.out.println(arr[i]);
        if(arr[i] != '#') i = check(i);
        return i;
    }
}