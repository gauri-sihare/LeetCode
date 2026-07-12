class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //har number or uski rank ussi order me print krwai j
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->  a- b );
        HashMap<Integer ,Integer> hm = new HashMap<>();

        for(int ele : arr){
            pq.add(ele);           // 40  , 30 , 20 , 10   
        }

        int j = 1;
        Integer prev = null;
        for(int ele :arr){
            int curr = pq.poll();
             if(prev ==null || curr != prev){
                hm.put(curr , j);    // 40 , 1 ,,

                j++;
                prev = curr;
            }

            
        }
        
        int [] abc = new int[arr.length];
        for(int i=0 ;i<abc.length ; i++){
            abc[i] = hm.get(arr[i]);
        }
        return abc;
    }
}