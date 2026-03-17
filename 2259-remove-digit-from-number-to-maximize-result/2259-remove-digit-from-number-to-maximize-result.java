import java.math.BigInteger;
class Solution {
   public String removeDigit(String number, char digit) {
        int removeIdx = -1;
        for(int i=0;i <number.length();i++) {
            if(number.charAt(i) == digit ){
                removeIdx = i;
                if(i+1 < number.length() && number.charAt(i+1) > digit ){
                    break;
                }
            }
        }
        return number.substring(0, removeIdx) + number.substring(removeIdx+1, number.length());
    }
}