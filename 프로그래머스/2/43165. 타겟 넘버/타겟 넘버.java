class Solution {
    int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return cnt;
    }
    
    void dfs(int [] numbers, int sum, int target, int d){
        if(d == numbers.length){
            if(sum == target)cnt++;
            return;
        }
        dfs(numbers, sum + numbers[d], target, d+1);
        dfs(numbers, sum - numbers[d], target, d+1);
    }
}