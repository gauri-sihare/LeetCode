class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] freqS = new int[26];
        int[] freqP = new int[26];
        for(int i =0; i< p.length(); i++){
            char ch = p.charAt(i);
            freqP[ch-'a'] = freqP[ch-'a']+1;
        }
        //freq of ele in p filled out
        for(int i=0; i<s.length(); i++){
            char chS = s.charAt(i);               //freq of s filled out.
            freqS[chS - 'a'] = freqS[chS - 'a'] +1;

            //if wind exceeds , remove left one
            if(i >= p.length()){
                freqS[ s.charAt( i-p.length()) - 'a']--;
            }

            //if both are equal
            if(Arrays.equals(freqS, freqP)){
                res.add( i-p.length() +1 );
            }
        }
        return res;
    }
}
