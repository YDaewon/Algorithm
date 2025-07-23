class Solution {
    public int searchInsert(int[] nums, int target) {
        int val = Arrays.binarySearch(nums, target);
        if(val >= 0) return val;
        else return -1*val -1;
    }
}