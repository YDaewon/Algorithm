import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 1;
        
        List<Integer> [] graph = new ArrayList[n + 1];
        boolean [] visit = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int [] node : edge){
            graph[node[0]].add(node[1]);
            graph[node[1]].add(node[0]);
        }
        
        int max = 0;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visit[1] = true;
        
        while(!q.isEmpty()){
            int [] cur = q.poll();
            if(max < cur[1]){
                max = cur[1];
                answer = 1;
            } else if(max == cur[1]){
                answer++;
            }
            for(int nxt : graph[cur[0]]){
                if(!visit[nxt]){
                    q.add(new int [] {nxt, cur[1] + 1});
                    visit[nxt] = true;
                }
            }
        }
        
        return answer;
    }
}