class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.add(x);
    }
    
    public int pop() {
        while(s1.size() != 1){
            int t = s1.pop();
            s2.add(t);
        }
        int result = s1.pop();
        while(!s2.isEmpty()){
            s1.add(s2.pop());
        }
        return result;
    }
    
    public int peek() {
        while(s1.size() != 1){
            int t = s1.pop();
            s2.add(t);
        }
        int result = s1.pop();
        s2.add(result);
        while(!s2.isEmpty()){
            s1.add(s2.pop());
        }
        return result;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */