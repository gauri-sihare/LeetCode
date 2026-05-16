class Solution {
       
        public int smooth(int row, int col, int[][] matrix){
             int sum=0;
             int avg =0;
             int count=0;
            int m = matrix.length;
            int n= matrix[0].length;

            int rowStart =  Math.max(row-1, 0);
            int colStart = Math.max(col-1, 0);
            int rowEnd = Math.min(row+1 , m-1);
            int colEnd = Math.min(col+1 , n-1);
            for(int i=rowStart; i<= rowEnd ; i++){
                for(int j=colStart ; j<=colEnd ;j++){
                    sum += matrix[i][j];
                    count++;
                }
            }
            avg = sum/count;
            return avg;
        }
    public int[][] imageSmoother(int[][] img) {
        int[][] smoothedArr = new int[img.length][img[0].length];
        for(int i =0; i < img.length; i++){
            for(int j=0; j< img[0].length ; j++){
                smoothedArr[i][j] = smooth(i, j, img);
            }
        }
        return smoothedArr;
    }
}