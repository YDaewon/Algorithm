class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int result = nums[0];
        for(int n : nums){
            if(result != n) cnt--;
            else cnt++;
            if(cnt == 0) {
                result = n;
                cnt++;
            }
        }

        return result;
    }
}