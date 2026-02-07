class Solution {
    public String solution(String s) {
        String answer = "";
        
        if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
            answer += (char)(s.charAt(0) - 32);
        } else answer += s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == ' ' && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') answer += (char)(s.charAt(i) - 32);
            else if(s.charAt(i-1) != ' ' && s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') answer += (char)(s.charAt(i) + 32);
            else answer += s.charAt(i);
        }
        
        
        return answer;
    }
}