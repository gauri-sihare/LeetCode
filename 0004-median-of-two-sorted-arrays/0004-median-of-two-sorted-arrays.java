class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //making nums1 as smaller one always
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int start =0; 
        int end  = n1;
        int N = n1+n2;
        while(end >= start){
            //mid=cut1
            int cut1= start + (end-start)/2;
            int cut2 = N/2 - cut1;
            int l1;
            int l2;
            int r1;
            int r2;
            if(cut1==0){
                 l1 = Integer.MIN_VALUE;
            }else{
                 l1 = nums1[cut1 -1];
            }

            if(cut2 == 0){
                 l2 = Integer.MIN_VALUE;
            }else{
                 l2 = nums2[cut2-1];
            }

            if(cut1 == n1){
                 r1 = Integer.MAX_VALUE;
            }else{
                 r1= nums1[cut1];
            }
            if(cut2 == n2){
                 r2 = Integer.MAX_VALUE;
            }else{
                 r2 = nums2[cut2];
            }

            //check if valid
            if(l1<= r2 && l2 <= r1){
                if(N%2 !=0 ){
                    return (double)Math.min(r1, r2);
                }else{
                    return (double)((Math.max(l1,l2)+ Math.min(r1,r2))/2.0);
                }
            }
            else if(l1>r2){
                end = cut1-1;
            }else{
                start = cut1+1;
            }
        }
        return 0.0;
    }
}