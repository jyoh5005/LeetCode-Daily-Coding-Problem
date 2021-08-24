class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int num1R = 0;
        int num1I;
        int num2R = 0;
        int num2I;
        for(;;num1R++){
            if(num1.charAt(num1R) == '+'){
                num1I = Integer.parseInt(num1.substring(num1R+1, num1.length()-1));
                num1R = Integer.parseInt(num1.substring(0, num1R));
                break;
            }
        }
        for(;;num2R++){
            if(num2.charAt(num2R) == '+'){
                num2I = Integer.parseInt(num2.substring(num2R+1, num2.length()-1));
                num2R = Integer.parseInt(num2.substring(0, num2R));
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        result.append((num1R * num2R - num1I * num2I));
        result.append('+');
        result.append((num1R * num2I + num1I * num2R));
        result.append('i');
        return result.toString();
    }
}