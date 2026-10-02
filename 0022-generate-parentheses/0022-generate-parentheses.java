class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
         genPar(res, "" , n, n);
         return res;
    }

    void genPar(List<String>res, String s, int leftparanthesis, int rightparanthesis){
        if(leftparanthesis== 0 && rightparanthesis ==0){
            res.add(s);
            return;
        }
        if( leftparanthesis > 0 ){
            genPar(res, s +"(", leftparanthesis -1, rightparanthesis);
        }
        if(rightparanthesis > leftparanthesis){
            genPar(res, s+ ")" , leftparanthesis , rightparanthesis - 1);
        }
    }
}