class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> count1 = new HashMap<>();
        HashMap<Integer, Integer> count2 = new HashMap<>();
        HashSet<Integer> keySet = new HashSet<>();
        for(int n : nums1){
            count1.put(n, count1.getOrDefault(n, 0)+1);
            keySet.add(n);
        }
        for(int n : nums2){
            count2.put(n, count2.getOrDefault(n, 0)+1);
            keySet.add(n);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int n : keySet){
            if(count1.containsKey(n) && count2.containsKey(n)){
                int limit = Math.min(count1.get(n), count2.get(n));
                for(int i = 0; i < limit; i++) result.add(n);
            }
        }
        int[] return_value = new int[result.size()];
        for(int i = 0; i < return_value.length; i++)  return_value[i] = result.get(i);
        return return_value;
    }
}