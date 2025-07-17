class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int temp = target - cur;
            if(map.containsKey(temp)){
                return new int[] {map.get(temp), i};
            }
            else{
                map.put(cur, i);
            }
        }
        return null;
    }
}