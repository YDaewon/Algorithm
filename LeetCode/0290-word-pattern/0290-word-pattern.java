class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] str = s.split(" ");
        Map<String, Character> sac = new HashMap<>();
        Map<Character, String> cas = new HashMap<>();
        if(str.length != pattern.length()) return false;
        for(int i = 0; i < str.length; i++){
            char c = pattern.charAt(i);
            if(cas.get(c) == null){
                if(sac.containsKey(str[i])) return false;
                cas.put(c, str[i]);
                sac.put(str[i], c);
            }
            else{
                if(!cas.get(c).equals(str[i])) return false;
            }
        }
        return true;
    }

}