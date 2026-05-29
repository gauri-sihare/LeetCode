class Solution {
    public String reorganizeString(String s) {

        char[] ch = s.toCharArray();
        int[] freq = new int[26];
        char[] res = new char[s.length()];
        
        for(int i =0; i< s.length(); i++){
            freq[ch[i] - 'a']++;
        }
    
        int max =0; //to store the char who has occured max times
        int letter =0;   //num of times its occurance
        for(int i =0; i<freq.length;i++){
            if(freq[i] > max ){
                max = freq[i];
                letter = i;
            }
        }

        if(max > (s.length()+1)/2){
            return "";              //aaab
        }

        int idx =0;
        while(freq[letter] > 0 ){
            res[idx] = (char)(letter+'a');
            idx+=2;
            freq[letter]--;
        }

        for(int i=0; i<26;i++){
            while(freq[i]-- > 0){
                if(idx >= res.length){
                    idx=1;
                }
                res[idx] = (char)(i +'a');
                idx+=2;
            }
           
        }
         return String.valueOf(res);
    }
}