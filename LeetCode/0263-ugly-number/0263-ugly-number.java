class Solution {
    public boolean isUgly(int n) {
        int num = 2;
        while(n > 1 && num < 6){
            if(n % num == 0) n /= num;
            else num++;
        }
        if(n != 1) return false;
        return true;
    }
}