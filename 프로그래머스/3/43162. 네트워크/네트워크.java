import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int [] visit = new int[n];
        
        for(int i = 0; i < n; i++){
            if(visit[i] == 0){
                answer++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visit[i] = 1;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int j =0; j < n; j++){
                        if(j == cur) continue;
                        if(visit[j] == 0 && computers[cur][j] == 1){
                            visit[j] = 1;
                            q.add(j);
                            //System.out.println("root: " + i + ", connect: " + j);
                        }
                    }
                } 
            }       
        }

        
        
        return answer;
    }
}