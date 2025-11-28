class Solution {
    public void moveZeroes(int[] nums) {
        int non_zero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                while(nums[non_zero] == 0 && non_zero < nums.length){
                    if(non_zero + 1 >= nums.length) break;
                    non_zero++;
                }
                int t = nums[non_zero];
                nums[non_zero] = 0;
                nums[i] = t;
            }
            else{
                non_zero++;
            }
        }
    }
}