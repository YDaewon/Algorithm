class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
            }
            else{
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                } else if(stack.peek() == '{' && s.charAt(i) == '}'){
                    stack.pop();
                } else if(stack.peek() == '[' && s.charAt(i) == ']'){
                    stack.pop();
                }
                else{
                    stack.add(s.charAt(i));
                }
            }
        }

        return stack.isEmpty();
    }
}