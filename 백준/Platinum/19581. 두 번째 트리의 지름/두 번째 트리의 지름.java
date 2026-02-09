import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [] p;
    static List<Edge> [] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 
        StringTokenizer st;
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(s, e, cost));
            graph[e].add(new Edge(e, s, cost));
        }
        
        Edge start2most = find_edge(1, -1);
        Edge most2most = find_edge(start2most.e, -1);
        Edge most2second = find_edge(most2most.s, most2most.e);
        Edge second2most = find_edge(most2most.e, most2most.s);

        // System.out.println("start2most: " + start2most.s + ", " + start2most.e + ", cost: " + start2most.cost);
        // System.out.println("most2most: " + most2most.s + ", " + most2most.e + ", cost: " + most2most.cost);
        // System.out.println("most2second: " + most2second.s + ", " + most2second.e + ", cost: " + most2second.cost);
        // System.out.println("second2most: " + second2most.s + ", " + second2most.e + ", cost: " + second2most.cost);

        Edge result = most2second.cost > second2most.cost ? most2second : second2most;

        System.out.println(result.cost);
    }

    static Edge find_edge(int s, int not){
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {s, 0});
        int max_cost = 0;
        int e = 0;
        boolean [] visit = new boolean[n+1];
        visit[s] = true;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            if(cur[1] > max_cost && cur[0] != not){
                max_cost = cur[1];
                e = cur[0];
            }
            for(Edge edge : graph[cur[0]]){
                if(!visit[edge.e] && edge.e != not) {
                    // System.out.println(cur[0]+ ", " + edge.e + ", " + (cur[1] + edge.cost));
                    visit[edge.e] = true;
                    q.add(new int [] {edge.e, cur[1] + edge.cost});
                }
            }
        }
        // System.out.println("==============");
        return new Edge(s, e, max_cost);
    }


    static class Edge{
        int s;
        int e;
        int cost;
        public Edge(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}
