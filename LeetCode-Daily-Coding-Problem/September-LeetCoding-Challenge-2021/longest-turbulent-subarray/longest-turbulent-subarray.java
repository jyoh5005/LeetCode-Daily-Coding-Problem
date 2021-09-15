class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int count = 0;
        int result = 1;
        boolean switching = true;
        for(int i = 0; i < arr.length-1; i++){
            // System.out.print(arr[i]);
            // System.out.print(' ');
            // System.out.print(arr[i+1]);
            // System.out.print(' ');
            if(arr[i] < arr[i+1]){
                if(switching){
                    switching = false;
                    count++;
                }
                else{
                    if(result <= count) result = count+1;
                    count = 1;
                }
            }
            else if(arr[i] > arr[i+1]){
                if(switching){
                    if(result <= count) result = count+1;
                    count = 1;
                }
                else{
                    switching = true;
                    count++;
                }
            }
            else{
                if(result <= count) result = count+1;
                count = 0;
            }
            // System.out.println(count);
        }
        if(result <= count) result = count+1;
        return result;
    }
}