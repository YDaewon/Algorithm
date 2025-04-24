import java.util.*;

class Solution {
    boolean solution(String str) {
        boolean answer = true;

        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '(') s.push('(');
            else if(c != '(' && !s.isEmpty()) s.pop();
            else return false;
        }
        

        return s.isEmpty();
    }
}