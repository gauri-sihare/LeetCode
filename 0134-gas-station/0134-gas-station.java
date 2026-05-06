class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0 ; int total_cost =0;
        for(int i =0 ; i< gas.length ; i++){
             total_gas = total_gas+ gas[i];
             total_cost = total_cost+ cost[i];
        }
        if(total_gas< total_cost){
            return -1;
        }

        int currentIdx =0 ; int startIdx=0;
        for(int i=0; i< gas.length ; i++){
            currentIdx = currentIdx + gas[i] - cost[i];

            if(currentIdx <0){
                startIdx = i+1;
                currentIdx = 0;
            }
        }
        return startIdx ;
    }
}