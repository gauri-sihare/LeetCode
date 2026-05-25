class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0; i< t.length(); i++){
            char ch = t.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) +1);
        }
        int startIdx = -1;
        int uniqueCount =freq.size();
        int winStart = 0;
        int winEnd = 0;
        int minLen = Integer.MAX_VALUE;
        int N= s.length();

        //expansion M<K<P<O        M-0  , 
        while(winEnd < N){
            char ch = s.charAt(winEnd);
            if( freq.containsKey(ch) ){
                freq.put(ch, freq.getOrDefault(ch, 0) -1 );
                if(freq.get(ch) == 0){
                    uniqueCount--;  
                }
            }
            //shrinking face , where u have got all elements of t in s , now u are shriking nd finding min one.
            while(uniqueCount ==0){
                int len  = winEnd- winStart +1;
                if(len < minLen){
                    minLen = len;
                    startIdx = winStart; //
                }
                ch = s.charAt(winStart);
                if(freq.containsKey(ch)){
                    freq.put(ch, freq.getOrDefault(ch, 0) +1 ); // +1 bcz ele is found again.
                    if(freq.get(ch) > 0){
                        uniqueCount++;
                    }
                }
                winStart++;
            }
            winEnd++;
        }
        if(startIdx == -1){
            return "";
        }
        return s.substring(startIdx, startIdx+minLen);
    }
}