class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> out = new ArrayList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        int total = m*n;
        int[][] temp = new int[m][n];

         for(int i =0; i< m  ;i++){
            for(int j=0; j<n ; j++){
                int oldIdx = i*n + j;
                int newIdx = (oldIdx + k) % total;
                int newRow = newIdx/n;
                int newCol = newIdx %n ;

                temp[newRow][newCol] = grid[i][j];
            }
        }

        for(int i =0; i< m  ;i++){
            List<Integer> al = new ArrayList<>();
            for(int j=0; j<n ; j++){
                al.add(temp[i][j]);
            }
            out.add(al);
        }
        return out;
    }
}