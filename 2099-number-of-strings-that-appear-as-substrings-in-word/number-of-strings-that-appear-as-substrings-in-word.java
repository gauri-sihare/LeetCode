class Solution {
    public int numOfStrings(String[] patterns, String word) {

        //HashSet<String> hm = new HashSet<>();
        int count=0;
        for(String pattern : patterns){
            if(word.contains(pattern)){
                count++;
            }
        }

        //     hm.add(pattern);
        //     word.contains
        // }

        // int count =0;
        // for(int i =0; i< word.length(); i++){
        //     for(int j=i+1 ; j<= word.length() ; j++){
        //         if(hm.contains(word.substring(i,j))){
        //            count++;
        //         }
        //     }
        // }
    return count;
    }
}