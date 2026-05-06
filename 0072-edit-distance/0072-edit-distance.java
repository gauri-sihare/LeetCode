class Solution {
    public int minDistance(String word1, String word2) {
        int n= word1.length();
        int m = word2.length();

        // make 2d dp
        int [][] dp = new int[n+1][m+1];
        //creating memoization , filled 1st row  1st col
        for(int i=1; i<=n; i++){
            dp[i][0] = i;
        }
        for(int j=1; j<=m ; j++){
            dp[0][j] = j;
        }
        // filling whole memoization problem
        for(int i =1; i<=n; i++){
            for(int j=1; j<=m ; j++){
                //if both letters are same
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int top = dp[i-1][j];
                    int topLeft =  dp[i-1][j-1];
                    int left = dp[i][j-1];
                    dp[i][j] = Math.min(top, Math.min(topLeft, left)) +1 ;
                }
            }
        }
    return dp[n][m];
    }
}