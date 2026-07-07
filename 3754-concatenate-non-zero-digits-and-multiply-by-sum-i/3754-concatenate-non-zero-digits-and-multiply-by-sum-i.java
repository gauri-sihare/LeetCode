class Solution {
    public long sumAndMultiply(int n) {
        String str = String.valueOf(n);

        long x=0;
        long sum =0;
        for(char ch : str.toCharArray()){
            if(ch == '0'){
                continue;
            }                                           //1234  
        long digit = ch -'0' ;
        x = x*10 + digit; //concatinate 

        sum+=digit;
        }
        return sum*x;
    }
}