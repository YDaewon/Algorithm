class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            if(map.getOrDefault(i, 0) == 0) map.put(i, 1);
            else return true;
        }

        return false;
    }
}