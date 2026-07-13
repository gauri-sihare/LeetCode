class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> al = new ArrayList<>();
        for(int  s = 1; s<= 8 ; s++){
            int num = s;
            for(int l = s+1 ; l<= 9 ;l++){
                num = num * 10 + l;
                if(num <= high && num >= low){
                    al.add(num);
                }
            }
        }
        Collections.sort(al);
        return al;
    }
}