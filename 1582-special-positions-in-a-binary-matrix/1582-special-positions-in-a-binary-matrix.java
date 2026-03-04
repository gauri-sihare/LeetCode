class Solution {
    public int numSpecial(int[][] mat) {

        int rescount =0;

        for(int i =0; i<mat.length; i++){
            for(int j=0; j< mat[i].length;j++){
                int rowcount1 =0;
                int colCount1 =0;

               if(mat[i][j] ==1){
                    
                    for(int row =0;row< mat.length ;row++){
                        if(mat[row][j] == 1){
                            rowcount1++;
                        }                           
                    }

                    for(int col=0 ; col<mat[i].length; col++){
                        if(mat[i][col] == 1){
                            colCount1++;
                        }
                    }

               }
               if(rowcount1 == 1 && colCount1 ==1){
                rescount++;
               }
            }
        }
        return rescount;
    }
}