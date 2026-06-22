class Solution {
    public int maxNumberOfBalloons(String text) {
        int count=0;
        Map<Character, Integer> hm = new HashMap<>();
        char[] ch  = text.toCharArray();

        for(char c : ch){
            hm.put( c, hm.getOrDefault(c, 0)+1);
        }

        int res = hm.getOrDefault('b', 0);

        res= Math.min( res ,hm.getOrDefault('a', 0));
        res=Math.min(res, hm.getOrDefault('l' , 0)/2) ;
        res=Math.min(res, hm.getOrDefault('o' , 0 )/2);
        res= Math.min(res, hm.getOrDefault('n' , 0));

        return res;
    }
}