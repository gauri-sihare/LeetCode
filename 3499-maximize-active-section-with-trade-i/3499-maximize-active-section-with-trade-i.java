class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int maxsumofzero =0;
        int one =0;
        int prevZero =0;

        int i=0;
        while(i<n){
            if(s.charAt(i) == '1'){
                one++;
                i++;
            }else{
                int curr =0;
                while(i<n && s.charAt(i) == '0'){
                    curr++;
                    i++;
                }
                if(prevZero > 0){
                    maxsumofzero = Math.max(maxsumofzero , prevZero + curr);
                }
                prevZero = curr;
            }
        }
        return one + maxsumofzero;
    }
}