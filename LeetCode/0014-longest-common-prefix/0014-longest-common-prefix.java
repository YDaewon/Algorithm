class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        int len = Integer.MAX_VALUE;
        for(String str : strs){
            len = Math.min(len, str.length());
        }

        for(int i = 0; i < len; i++){
            char temp = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(temp != strs[j].charAt(i)) return answer;
            }
            answer += temp;
        }
        return answer;
    }
}