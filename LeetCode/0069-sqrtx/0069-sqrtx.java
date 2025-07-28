class Solution {
    public int mySqrt(int x) {
        int cnt = 0;
        while((cnt+1)*(cnt+1) <= x){
            cnt++;
        }
        return cnt;
    }
}