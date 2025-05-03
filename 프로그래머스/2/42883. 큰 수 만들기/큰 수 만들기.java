import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int n = number.length();
        Stack<Character> s = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            char c = number.charAt(i);
            while(!s.isEmpty() && s.peek() < c && cnt < k){
                s.pop();
                cnt++;
            }            
            s.push(c);
        }
        
        for(char c : s){
            answer += c;
        }  
        if(answer.length() > number.length() - k){
            answer = answer.substring(0, number.length() - k);
        }
        
        return answer;
    }
}