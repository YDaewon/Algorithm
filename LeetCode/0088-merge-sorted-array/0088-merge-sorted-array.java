class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {        
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < m + n && idx2 < n){
            if(nums1[idx1] == 0) nums1[idx1] = nums2[idx2++];
            idx1++;
        }
        Arrays.sort(nums1);
    }
}