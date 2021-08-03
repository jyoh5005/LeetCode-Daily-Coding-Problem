class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        result.add(temp);
        int number = nums[0];
        int count = 0;
        for(int n : nums){
            if(n == number) count++;
            else{
                int size = result.size();
                for(int i = 0; i < size; i++){
                    temp = new ArrayList<Integer>(result.get(i));
                    for(int j = 0; j < count; j++){
                        temp.add(number);
                        result.add(new ArrayList<Integer>(temp));
                    }
                }
                count = 1;
                number = n;
            }
        }
        int size = result.size();
        for(int i = 0; i < size; i++){
            temp = new ArrayList<Integer>(result.get(i));
            for(int j = 0; j < count; j++){
                temp.add(number);
                result.add(new ArrayList<Integer>(temp));
            }
        }
        return result;
    }
}