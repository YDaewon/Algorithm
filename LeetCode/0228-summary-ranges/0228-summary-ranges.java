class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0) return result;
        int start = nums[0];
        int end = nums[0];


        for(int i = 0; i < nums.length; i++){
            end = nums[i];

            if(i == nums.length - 1 || nums[i] + 1 != nums[i+1]){
                if(start == end){
                    result.add(String.valueOf(start));
                }
                else{
                    result.add(start + "->" + end);
                }
                if(i < nums.length -1) start = nums[i+1];
            }
        }

        return result;
    }
}