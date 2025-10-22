class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(map.containsKey(sc)){ // already mapping 
                if(map.get(sc) != tc) return false;
            }
            else{
                if(set.contains(tc)) return false;
                map.put(sc, tc);
                set.add(tc);
            }
        }

        return true;
    }
}