import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        int [] answer = new int [V+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        List<Node> [] graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        answer[start] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(Node node : graph[cur.x]){
                int nxt_cost = cur.cost + node.cost;
                if(answer[node.x] > nxt_cost){
                    answer[node.x] = nxt_cost;
                    pq.add(new Node(node.x, nxt_cost));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) sb.append((answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]) + "\n");
        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int x;
        int cost;

        Node(int x, int c){
            this.x = x;
            this.cost = c;
        }

        @Override
        public int compareTo(Node o){
            return this.cost > o.cost ? 1 : -1;
        }
    }
}
