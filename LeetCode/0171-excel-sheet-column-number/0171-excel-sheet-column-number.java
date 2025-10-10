class Solution {
    public int titleToNumber(String str) {
        int res = 0;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            res += c - 'A' + 1;
            if(i < str.length() - 1) res *= 26;
        }

        return res;
    }
}