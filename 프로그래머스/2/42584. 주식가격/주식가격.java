import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && stack.peek().price > prices[i]){
                Node node = stack.pop();
                answer[node.idx] = i - node.idx;
            }
            stack.push(new Node(i, prices[i]));
        }
        
        while(!stack.isEmpty()){
            Node node = stack.pop();
            answer[node.idx] = prices.length - node.idx - 1;
        }
        
        
        return answer;
    }
    
    static class Node{
        int idx;
        int price;
        Node(int idx, int price){
            this.idx = idx;
            this.price = price;
        }
    }
}