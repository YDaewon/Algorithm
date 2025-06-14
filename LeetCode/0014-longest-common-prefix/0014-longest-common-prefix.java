class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String a = strs[0];
        String b = strs[strs.length -1];

        for(int i = 0; i < strs[0].length(); i++){
            char t1 = a.charAt(i);
            char t2 = b.charAt(i);
            if(t1 != t2) return a.substring(0, i);
        }
        return a;
    }
}