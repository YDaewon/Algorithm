class Solution {
    public int searchInsert(int[] nums, int target) {
        int val = Arrays.binarySearch(nums, target);
        if(val < 0) val = -1*val -1;
        return val;
    }
}