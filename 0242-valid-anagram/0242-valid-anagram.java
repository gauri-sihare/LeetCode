class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        s = s.toLowerCase();
        t = t.toLowerCase();

        int sfreq[] = new int[26];
        int tfreq[] =  new int[26];
        for(int i =0; i< s.length() ; i++){
            char ch =  s.charAt(i);
            sfreq[ch-'a']++;
        }
        for(int i=0; i< t.length(); i++){
            char tch =  t.charAt(i);
            tfreq[tch-'a']++;
        }

        if(Arrays.equals(sfreq , tfreq)){
            return true;
        }
        return false;
    }
}