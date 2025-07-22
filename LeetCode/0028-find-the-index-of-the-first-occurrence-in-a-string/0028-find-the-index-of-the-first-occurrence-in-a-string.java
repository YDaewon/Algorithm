class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i++){
            char c = haystack.charAt(i);
            if(c == needle.charAt(0) && i + needle.length() <= haystack.length() && haystack.substring(i, i + needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}