class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
         genPar(res, "" , n, n);
         return res;
    }

    void genPar(List<String>res, String s, int left, int right){
        if(left== 0 && right ==0){
            res.add(s);
            return;
        }
        if(left>0){
            genPar(res, s +"(", left-1, right);
        }
        if(right>left){
            genPar(res, s+")", left, right-1);
        }
    }
}