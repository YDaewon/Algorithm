class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(nums[i] == val) {
                nums[i] = 51;
                cnt++;
            }
        }
        Arrays.sort(nums);
        return size - cnt;
    }
}