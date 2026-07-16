class Solution {
    public long gcdSum(int[] nums) {
        int max   = 0;
        int []pregcd = new int[nums.length];
        for(int i =0; i<nums.length ;i++){  
            max = Math.max(max , nums[i]);
            pregcd[i] = gcd(max , nums[i] );
        }   
        long res = 0; 
        Arrays.sort(pregcd);
        
        for(int i=0 , j= nums.length-1 ; i<j ;i++ , j--){
                res += gcd(pregcd[i] , pregcd[j]) ;
             
        }
        return res;
    }
    public int gcd(int a , int val){
        if(val == 0){
            return a;
        }
        return gcd(val , a %val);
    }
}