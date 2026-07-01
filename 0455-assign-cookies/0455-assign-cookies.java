class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);

        int satis = 0;
        int sIdx =0 ;
        int gIdx =0 ;

            while( gIdx < g.length && sIdx < s.length){
                if(g[gIdx] > s[sIdx]){
                    sIdx++;
                }
                else if(g[gIdx] <= s[sIdx]){
                    satis++;
                    gIdx++;
                    sIdx++;
                }
            }
        return satis;
    }
}