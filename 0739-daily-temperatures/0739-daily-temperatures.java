class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i = n-1; i>=0 ; i--){
            while(!temp.isEmpty() && temperatures[i] >= temperatures[temp.peek()] ){
                temp.pop();
            }
            if(!temp.isEmpty()){
                res[i] = temp.peek() - i;
            }    
        temp.push(i);
        }
         return res;
    }
}