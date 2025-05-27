import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean flag = true;
        for(String nxt : words){
            if(nxt.equals(target)) flag = false;
        }
        if(flag) return 0;
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.str.equals(target)){
                answer = cur.cost;
                break;
            }
            for(String nxt : words){
                if(cur.possible(nxt)) q.add(new Node(nxt, cur.cost + 1));
            }
        }
            
        return answer;
    }
}

class Node implements Comparable<Node>{
    String str;
    int cost;
    
    Node(String str, int cost){
        this.str = str;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
    
    boolean possible(String nxt){
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != nxt.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        return true;
    }
}