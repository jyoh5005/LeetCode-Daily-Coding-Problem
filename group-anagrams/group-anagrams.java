class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(!result.containsKey(key)) result.put(key, new ArrayList<String>());
            result.get(key).add(s);
            
        }
        List<List<String>> return_value = new ArrayList<>();
        for(List<String> list : result.values()) return_value.add(list);
        return return_value;
    }
}