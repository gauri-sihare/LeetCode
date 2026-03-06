class Solution {
    public boolean checkOnesSegment(String s) {
        // if(s.length()==1 && s.charAt(0)==1){
        //     return true;
        // }
        
        for(int i =s.length()-1 ; i>=1 ;i--){
            if(s.charAt(i) == '1' && s.charAt(i-1) =='0'){
                return false;
            }
        }
        return true;
    }
}