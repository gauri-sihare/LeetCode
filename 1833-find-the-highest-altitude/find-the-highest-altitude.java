class Solution {
    public int largestAltitude(int[] gain) {
        int[] sum = new int[gain.length +1];
        sum[0]= 0;
        int ans=0;
        for(int i=0; i< gain.length; i++){
            sum[i+1] = sum[i] + gain[i];
            ans = Math.max(ans, sum[i+1]);
        }
        return ans;
    }
}