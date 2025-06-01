class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] ransom = new int [26];
        int [] maga = new int [26];
        for(char c : ransomNote.toCharArray()){
            ransom[c-'a']++;
        }
        for(char c : magazine.toCharArray()){
            maga[c-'a']++;
        }

        int cnt = magazine.length();
        for(int i = 0; i < 26; i++){
            if(maga[i] - ransom[i] < 0) return false;
            else{
                maga[i] = maga[i] - ransom[i];
                cnt -= ransom[i];
                if(cnt < 0) return false;
            }
        }


        return true;
    }
}