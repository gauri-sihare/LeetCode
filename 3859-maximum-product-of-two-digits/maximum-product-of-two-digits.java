class Solution {
    public int maxProduct(int n) {
        int firstlar = Integer.MIN_VALUE;
        int seclar  =  Integer.MIN_VALUE;

        while(n > 0) {
            int last_dig = n%10;
            if(last_dig >= seclar ){
                seclar = last_dig;
            }
             if(last_dig >= firstlar){  
                seclar = firstlar;              
                firstlar = last_dig;
                
            }
            n = n /10;
        }
        int ans = firstlar*seclar;
        return ans;
    }
}