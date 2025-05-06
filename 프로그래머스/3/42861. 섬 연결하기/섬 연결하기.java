import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int cnt = 0;
        boolean visit[] = new boolean [n];
        int [][] islands = new int[n][n];
        for(int [] island : costs){
            int f = island[0];
            int s = island[1];
            int cost = island[2];
            islands[f][s] = cost;
            islands[s][f] = cost;
        }
        
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1; i < n; i++){
            if(islands[0][i] != 0){
                pq.add(new Node(0, i, islands[0][i]));
            }
        }
        visit[0] = true;
        while(!pq.isEmpty() && cnt < n-1){
            Node now = pq.poll();   
            if(visit[now.second]) continue;
            
            answer += islands[now.first][now.second];
            visit[now.second] = true;
            cnt++;
            System.out.println(now.first + " -> " + now.second + "로 이동, 비용: " + islands[now.first][now.second]);
            
            for(int i = 0; i < n; i++){
                if(islands[now.second][i] != 0 && !visit[i]){
                    pq.add(new Node(now.second, i, islands[now.second][i]));
                }
            }
        }
        
        return answer;
    }
    
    class Node implements Comparable<Node>{
        int first;
        int second;
        int cost;
        Node(int first, int second, int cost){
            this.first = first;
            this.second = second;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n1){
            return this.cost > n1.cost ? 1 : -1;
        }
    }
}