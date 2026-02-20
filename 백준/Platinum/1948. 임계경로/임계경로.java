 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int start, rome;
    static int [] dist; // 출발 기준
    static List<Node> [] road;
    static List<Node> [] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        road = new ArrayList[n+1];
        prev = new ArrayList[n+1];
        dist = new int [n+1];
        for (int i = 1; i <= n; i++) {
            road[i] = new ArrayList<>();    
            prev[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            road[s].add(new Node(e, cost));
            prev[e].add(new Node(s, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        rome = Integer.parseInt(st.nextToken());

        bfs();
        // for (int i = 1; i <= n; i++) {
        //     System.out.print(dist[i] + " ");
        // }
        // System.out.println();
        System.out.println(dist[rome]);
        System.out.println(count_road());
    }

    static void bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.cost - a.cost);
        pq.add(new Node(start, 0)); // x, time

        while(!pq.isEmpty()){
            Node c = pq.poll();

            for(Node nxt : road[c.x]){
                if(dist[nxt.x] >= dist[c.x] + nxt.cost) continue;
                dist[nxt.x] = dist[c.x] + nxt.cost;
                pq.add(new Node(nxt.x, dist[nxt.x]));
            }
        }
    }
    static int count_road(){
        boolean [] visit = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.cost - a.cost);
        pq.add(new Node(rome, 0)); // x, time
        visit[rome] = true;
        int cnt = 0;
        while(!pq.isEmpty()){
            Node c = pq.poll();

            for(Node p : prev[c.x]){
                if(dist[c.x] != dist[p.x] + p.cost) continue;
                cnt++;
                if(visit[p.x]) continue;
                visit[p.x] = true;
                pq.add(new Node(p.x, 0));
            }
        }

        return cnt;
    }

    // 6으로 오는게 2개

    // 1. 1 -> 2 -> 7 : 4 + 5 = 9
    // 2. 1 -> 2 -> 6 -> 7 : 4 + 3 + 5 = 12
    // 3. 1 -> 3 -> 5 -> 6 -> 7 : 2 + 1 + 2 + 5 = 10
    // 4. 1 -> 4 -> 6 -> 7 -> 3 + 4 + 5 = 12
    // 가장 오래 달린 사람들이 달린 도로: 2, 4 => 5개


    static class Node{
        int x;
        int cost;

        Node(int x, int cost){
            this.x = x;
            this.cost = cost;
        }
    }
}
