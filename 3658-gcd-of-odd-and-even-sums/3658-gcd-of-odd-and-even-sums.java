class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = -1;
        int sumEven = 0;
        int currentEven =0;
        int currOdd = 0;
        // int res=0;
        for(int i=0;i< n ;i++){
            sumEven += 2;  // 0+2+4+6..
            currentEven +=sumEven;
            sumOdd +=2;   // 1+3+4
            currOdd += sumOdd;
        }

        for(int i=Math.min(currOdd, currentEven) ; i> 1 ; i--){
            if( currOdd % i ==0 && currentEven % i == 0 ){
                return i;
            }
        }
        return 1;
    }

}