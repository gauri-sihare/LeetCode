class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int currBit =0;
        int startBit = 0;
        int mincount=0;

        for(int i =0; i<n; i++){
             currBit = s.charAt(i) - '0';
            
            if(currBit == startBit){
                currBit = 1- startBit; //flip
                mincount++;
            }
            startBit = currBit;
        }
        return Math.min(mincount, n-mincount );
    }
}