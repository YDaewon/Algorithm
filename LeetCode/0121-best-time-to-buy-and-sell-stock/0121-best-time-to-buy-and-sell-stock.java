class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int cur = prices[0];
        int cnt = 0;
        int result = 0;
        for(int i = 1; i < len; i++){
            if(cur < prices[i]){
                result = Math.max(result, prices[i] - cur);
            }
            else {
                cur = prices[i];
            }
        }

        return result;
    }
}