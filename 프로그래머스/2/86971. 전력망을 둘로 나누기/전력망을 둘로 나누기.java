import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        int [][] graph = new int[n+1][n+1];
        for(int [] wire : wires){
            int t1 = wire[0];
            int t2 = wire[1];
            graph[t1][t2] = 1;
            graph[t2][t1] = 1;
        }
        
        for(int [] wire : wires){
            int t1 = wire[0];
            int t2 = wire[1];
            graph[t1][t2] = 0;
            graph[t2][t1] = 0;
            
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            int cnt = 1;
            boolean [] visit = new boolean[n+1];
            visit[1] = true;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int i = 1; i <= n; i++){
                    if(graph[cur][i] != 0 && !visit[i]){
                        visit[i] = true;
                        q.add(i);
                        cnt++;
                        //System.out.print(i + ", ");
                    }
                }
            }
            int non = n - cnt;
            //System.out.println("1에서 연결된 탑 개수: " + cnt);
            answer = Math.min(answer, Math.abs(non - cnt));
            graph[t1][t2] = 1;
            graph[t2][t1] = 1;
        }
        
        
        return answer;
    }
}