class Solution {
    public String orderlyQueue(String s, int k) {
        if(k >= 2){
            char[] carr =  s.toCharArray();
            Arrays.sort(carr);
            return new String(carr);
        }
        else{
            int size = s.length();
            StringBuilder strbid = new StringBuilder(s);
            String result = new String(s);
            for(int i = 0; i < size; i++){
                strbid.delete(0,1);
                strbid.append(s.charAt(i));
                if(result.compareTo(strbid.toString()) > 0) result = strbid.toString();
            }
            return result;
        }
    }
}