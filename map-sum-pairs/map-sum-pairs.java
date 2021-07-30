class MapSum {
    private HashMap<String, Integer> hm;
    /** Initialize your data structure here. */
    public MapSum() {
        hm = new HashMap<String, Integer>();
    }
    
    public void insert(String key, int val) {
        hm.put(key, val);
    }
    
    public int sum(String prefix) {
        int result = 0;
        for(String str : hm.keySet()){
            if(str.indexOf(prefix) == 0){
                result += hm.get(str);
            }
        }
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */