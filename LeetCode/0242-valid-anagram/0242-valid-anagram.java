class Solution {
    public boolean isAnagram(String s, String t) {
        char [] alpha = new char [27];

        for(int i = 0; i < s.length(); i++){
            alpha[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            alpha[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(alpha[i] != 0) return false;
        }
        return true;
    }
}