class Solution {
    public int numTrees(int n) {
        if(n == 1) return 1;
        List<Integer> list = new ArrayList<Integer>();
        getNumTrees(list, n);
        return list.get(n);
    }
    private void getNumTrees(List<Integer> list, int n){
        if(n == 1){
            list.add(1);
            list.add(1);
            return;
        }
        
        getNumTrees(list, n-1);
        int value = 0;
        for(int i = 0; i < n; i++){
            value += list.get(i) * list.get(n-i-1);
        }
        list.add(value);
        return;
    }
}