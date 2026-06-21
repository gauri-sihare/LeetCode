class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int coinsLeft = coins;
        int count =0;
        Arrays.sort(costs);
        for(int i =0; i<costs.length; i++){
            if(costs[i] <= coinsLeft && coinsLeft >=0){
//                coinsLeft = costs[i];
                coinsLeft -= costs[i];
                count++;
            }
        }
        return count;
    }
}