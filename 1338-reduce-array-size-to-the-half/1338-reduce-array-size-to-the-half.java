class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int ele : arr){
            hm.put(ele, hm.getOrDefault(ele ,0) +1); 
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);


        int half = arr.length/2;
        int sum =0;
        int count=0;
        pq.addAll(hm.values());
        for(int i =0; i< hm.size() ; i++){
            int freq= pq.poll();
            sum += freq;
            count++;
            if( sum >= half){
                return count;
            }
        }
        return count;
    }
}