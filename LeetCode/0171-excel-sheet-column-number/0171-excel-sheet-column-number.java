class Solution {
    public int titleToNumber(String str) {
        int res = 0;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            res *= 26;
            res += c - 'A' + 1;
        }

        return res;
    }
}