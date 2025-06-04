class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int s = x;
        int r = 0;
        int t = 0;
        while(s != 0){
            t = s % 10;
            s /= 10;
            r = r*10 + t;
        }
        //System.out.println(x + ", " + r);
        return x == r;
    }
}