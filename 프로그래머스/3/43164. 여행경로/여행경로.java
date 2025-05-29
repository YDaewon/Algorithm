import java.util.*;

class Solution {
    List<String> answer;
    boolean flag = false;
    boolean [] visited;
    public List<String> solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (o1,o2) -> o1[1].compareTo(o2[1]));
        boolean [] visited = new boolean[tickets.length];
        dfs(0, new ArrayList<>(List.of("ICN")), "ICN", tickets);
        return answer;
    }
    
    void dfs(int depth, List<String> path, String now, String[][] tickets){
        if(flag) return;
        if(depth == tickets.length){
            answer = new ArrayList<>(path);
            flag = true;
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            String nxt = tickets[i][1];
            if(!visited[i] && tickets[i][0].equals(now)){
                visited[i] = true;
                path.add(nxt);
                dfs(depth+1, path, nxt, tickets);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}