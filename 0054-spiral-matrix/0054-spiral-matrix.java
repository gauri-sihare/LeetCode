class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       
        int rowBeg =0;
        int colBeg= 0 ;
        int rowEnd= matrix.length-1;
        int colEnd= matrix[0].length-1;

        List<Integer> result =new ArrayList<>();

        if(matrix.length ==0){
            return result;
       }


        while(rowBeg<= rowEnd && colBeg<=colEnd){
            //traverse right
            for(int j=colBeg ; j<=colEnd;j++){
               result.add(matrix[rowBeg][j]);
                
            }
            rowBeg++;
            //traverse down 
            for(int j=rowBeg; j<=rowEnd;j++){
                result.add(matrix[j][colEnd]);
            }
            colEnd--;
            //traverse left 
            if(rowEnd>=rowBeg){
                for(int j =colEnd; j>=colBeg;j--){
                result.add(matrix[rowEnd][j]);
               
            }
            }
             rowEnd--;
            // traverse up
            if(colEnd>=colBeg){
                for(int j=rowEnd; j>=rowBeg;j--){
                    result.add(matrix[j][colBeg]);
                }
            }
            colBeg++;

        }
        return result;
    }
}