class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] str = s.split(" ");
        Map<Character, String> pat = new HashMap<>();

        for(int i = 0; i < str.length; i++){
            if(pat.getOrDefault(pattern.charAt(i), null) == null){
                pat.put(pattern.charAt(i), str[i]);
            }
            else{
                if(!pat.get(pattern.charAt(i)).equals(str[i])) return false;
            }
        }
        return true;
    }

}