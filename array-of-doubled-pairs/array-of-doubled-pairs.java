class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if(arr.length == 0) return true;
        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();
        for(int i : arr){
            if(i == 0) continue;
            else if(i % 2 == 0){
                int t = even.getOrDefault(i/2, 0);
                even.put(i/2, t+1);
            }
            else{
                int t = odd.getOrDefault(i, 0);
                odd.put(i, t+1);
            }
        }
        while(!even.isEmpty()){
            // System.out.println("odd");
            // outing(odd);
            // System.out.println("even");
            // outing(even);
            for(int i : odd.keySet()){
                int t = even.getOrDefault(i, 0);
                if(t < odd.get(i)) return false;
                else even.replace(i, t-odd.get(i));
            }
            Map<Integer, Integer> temp = new HashMap<>(even);
            odd.clear();
            even.clear();
            for(int i : temp.keySet()){
                if(i == 0 || temp.get(i) <= 0) continue;
                else if(i % 2 == 0) even.put(i/2, temp.get(i));
                else odd.put(i, temp.get(i));
            }
        }
        if(odd.isEmpty()) return true;
        else return false;
    }
    // private void outing(Map<Integer, Integer> mp){
    //     for(int i : mp.keySet()){
    //         System.out.print(i);
    //         System.out.print(':');
    //         System.out.print(mp.get(i));
    //         System.out.print(' ');
    //     }
    //     System.out.println();
    //     return;
    // }
}