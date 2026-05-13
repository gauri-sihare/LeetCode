class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st  = new Stack<>();
        int[] lm = new int[heights.length];
        int[] rm = new int[heights.length];

            //for left min
           for(int i = 0 ; i< heights.length ;i++){
                while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    lm[i] = -1;
                }else{
                    lm[i] = st.peek();
                }
            st.push(i);
           }
        // for right min
        st.clear();

        for(int i= heights.length-1 ; i>=0 ; i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()] ){
                st.pop();
            }
            if(st.isEmpty()){
                rm[i] = heights.length;
            }else{
                rm[i] = st.peek();
            }
            st.push(i);
        }

        //cal area
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i< heights.length ;i++){
            int width = rm[i] - lm[i] -1;
            int area = heights[i] * width;
            maxArea = Math.max( maxArea , area);
            
        }
        return maxArea;
    }
}