class Solution {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int res =0;
        
        if(cost.length == 1){
            return cost[0];
        }
        for(int cos : cost){
            pq.offer(cos);
        }
        while(!pq.isEmpty() ){
            if(!pq.isEmpty()){
                res+=pq.poll();
            }
            if(!pq.isEmpty()){
                res += pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
            }
            
        }
        
        return res;
    }
}