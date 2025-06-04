class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int s = x;
        int r = 0;
        while(x != 0){
            int t = x % 10;
            x /= 10;
            r = r*10 + t;
        }
        //System.out.println(x + ", " + r);
        return s == r;
    }
}