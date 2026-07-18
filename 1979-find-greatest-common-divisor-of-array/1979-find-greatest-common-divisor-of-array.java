class Solution {
    public int findGCD(int[] nums) {
        int min  = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
             min = Math.min(num , min);
             max = Math.max(num , max);
        }
        return gcd(min , max);
    }
    public int gcd(int a , int b ){
        if(b==0){
            return a;
        }
        return gcd(b , a%b);
    }
}