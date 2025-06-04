class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        char [] num = String.valueOf(x).toCharArray();
        int len = num.length;
        int mid = len / 2;
        for(int i = 0; i < mid; i++){
            if(num[i] != num[len - 1 - i]) return false;
        }
        return true;
    }
}