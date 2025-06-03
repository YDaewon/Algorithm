class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length; i++)
        {
            int first=nums[i];
            int second=target-first;
            if(map.containsKey(second))
            {
                return new int[]{map.get(second),i};
            }
            else
            {
                map.put(nums[i],i);
            }
        }
         return new int[]{-1,-1};
    }
}