class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans =0;
        for(int i = num1 ; i<= num2 ; i++){
             ans += waviness( i );

        }
        return ans;
    }
    int waviness(int nums){
        int wave = 0;
        String str = Integer.toString(nums);
        char[] ch = str.toCharArray();
        for(int i=1 ; i< ch.length-1 ; i++){
            if((ch[i] < ch[i+1] && ch[i] < ch[i-1]) || ch[i] > ch[i+1] && ch[i]> ch[i-1]){
                wave++;
            }
        }
        return wave;
    }
}