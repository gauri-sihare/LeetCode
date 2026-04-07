class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char[] cjewels = jewels.toCharArray();
        char[] cstones = stones.toCharArray();
       HashSet<Character> hm = new HashSet<>();
       int count =0;

       for(int i =0;i<jewels.length(); i++){
        hm.add(cjewels[i]);
       }

       for(int i =0; i< stones.length(); i++){
        if(hm.contains(cstones[i])){
            count++;
        }

       } 
       return count;    
    }
}