class Solution {
    int[][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[1001][1001];

        for(int[] idx : dp){
            Arrays.fill(idx , -1);
        }

        return solve(text1 , text2 , 0 , 0);

    }

    
    public int solve(String text1 , String text2 , int i , int j ){

        int m = text1.length();
        int n = text2.length();

        if(i>= m || j>= n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1+solve(text1 , text2 , i+1 , j+1);
        }else{
            return dp[i][j] = Math.max( (solve(text1, text2, i+1 , j)) , 
                                        (solve(text1, text2 , i, j+1)));

        }
    }

}