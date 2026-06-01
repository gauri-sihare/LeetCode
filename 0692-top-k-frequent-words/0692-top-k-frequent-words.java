class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String ,Integer> hm = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(
        (a,b)->{
                if( hm.get(b).equals( hm.get(a) ) ){   //if freq are same
                    return a.compareTo(b);    //order them by thier lexical order.
                }
                return hm.get(b)- hm.get(a);  //sort by freq in desc order
            }
        );

        for(int i =0 ; i< words.length; i++){
            hm.put(words[i]  , hm.getOrDefault(words[i] , 0) +1);
        }
        
        pq.addAll(hm.keySet());

        ArrayList<String> res = new ArrayList<>();
        for(int i=0; i<k ; i++){
            res.add(pq.poll());
        }
        return res;
    }
}