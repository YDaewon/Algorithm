 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int start, rome;
    static int [] dist;
    static List<Node> [] road, prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        road = new List[n+1];
        prev = new List[n+1];
        
        for (int i = 1; i < n+1; i++) {
            road[i] = new ArrayList<>();
            prev[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            road[s].add(new Node(e, c));
            prev[e].add(new Node(s, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        rome = Integer.parseInt(st.nextToken());

        get_dist();
        System.out.println(dist[rome]);

        int cnt = paint_gold();
        System.out.println(cnt);
    }

    private static int paint_gold() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.cost - a.cost);
        int cnt = 0;
        pq.add(new Node(rome, 0));

        boolean [] visit = new boolean[n+1];
        visit[rome] = true;
        while(!pq.isEmpty()){
            Node c = pq.poll();
            
            for(Node pre : prev[c.x]){
                if(dist[c.x] == dist[pre.x] + pre.cost){
                    cnt++;
                    if(!visit[pre.x]){
                        pq.add(new Node(pre.x, dist[pre.x]));
                        visit[pre.x] = true;
                    }
                }
            }
        }

        return cnt;
    }

    static void get_dist(){
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.cost - a.cost);

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node c = pq.poll();

            for(Node nxt : road[c.x]){
                if(dist[nxt.x] < dist[c.x] + nxt.cost){
                    dist[nxt.x] = dist[c.x] + nxt.cost;
                    pq.add(new Node(nxt.x, dist[nxt.x]));
                }
            }
        }
    }

    static class Node{
        int x;
        int cost;
        Node(int x, int cost){
            this.x = x;
            this.cost = cost;
        }
    }

}
