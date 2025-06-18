class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{
                if(c == '(' || c == '[' || c == '{' ){
                    stack.push(c);
                }
                else if(stack.peek() == '(' && c == ')'){
                    stack.pop();
                } else if(stack.peek() == '{' && c == '}'){
                    stack.pop();
                } else if(stack.peek() == '[' && c == ']'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}