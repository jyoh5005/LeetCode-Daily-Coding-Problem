class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        int[] alpabet = new int[52];
        for(char c : t.toCharArray()){
            if(c >= 'a' && c <= 'z') alpabet[c-'a'+26]++;
            else alpabet[c-'A']++;
        }
        int b = 0;
        int e = 0;
        String result = new String(s);
        boolean isReturnNull = true;
        while(e < s.length()){
            char c = s.charAt(e);
            if(c >= 'a' && c <= 'z') alpabet[c-'a'+26]--;
            else alpabet[c-'A']--;
            if(check(alpabet)){
                for(; b <= e; b++){
                    c = s.charAt(b);
                    if(c >= 'a' && c <= 'z') alpabet[c-'a'+26]++;
                    else alpabet[c-'A']++;
                    if(!check(alpabet)){
                        isReturnNull = false;
                        if(e-b+1 < result.length()){
                            result = s.substring(b, e+1);
                        }
                        b++;
                        break;
                    }
                }
            }
            e++;
        }
        if(isReturnNull) return "";
        return result;
    }
    private boolean check(int[] alpabet){
        for(int i = 0; i < 52; i++) if(alpabet[i] > 0) return false;
        return true;
    }
}