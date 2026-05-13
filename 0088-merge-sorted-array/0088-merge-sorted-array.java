class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r1 = m - 1;
        int r2 = n - 1;
        int w  = m + n - 1;  //length of o/p arr

        while (r1 >= 0 && r2 >= 0) {
            if (nums1[r1] > nums2[r2]) {            //backwards loop chal rha h
                nums1[w] = nums1[r1];          /// last se ele bharana start kr rhe h 
                r1--;
            } else {
                nums1[w] = nums2[r2];
                r2--;
            }
            w--;
        }

        while (r2 >= 0) {                 // agr r2 mtlb 2nd arr k ele bach jate h toh put it in the left space in the o/p arr
            nums1[w] = nums2[r2];
            r2--;
            w--;
        }
    }
}
