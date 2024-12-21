import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Node>[] cost = new ArrayList[n+1];
        int [] dist = new int [n+1];
        for (int i = 0; i <= n; i++) {
            cost[i] = new ArrayList<>();
            dist[i] = 50000 * 1000;
        }


        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[s].add(new Node(e, c));
            cost[e].add(new Node(s, c));
        }
        // Input

        int start = 1;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            for(Node next : cost[now.cur]){
                if(dist[next.cur] > dist[now.cur] + next.cost){
                    dist[next.cur] = dist[now.cur] + next.cost;
                    pq.offer(new Node(next.cur, dist[next.cur]));
                }
            }
        }
        System.out.println(dist[n]);
    }


    static class Node implements Comparable<Node>{
        int cur;
        int cost;
        Node(int cur, int cost){
            this.cur = cur;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }
}