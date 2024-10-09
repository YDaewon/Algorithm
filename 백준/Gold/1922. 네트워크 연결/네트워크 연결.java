import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Node> [] nodes = new ArrayList[n+1];
        boolean [] visit = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            nodes[s].add(new Node(e, c));
            nodes[e].add(new Node(s, c));
        }
        pq.add(new Node(1,0));
        long ans = 0, cnt = 1;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visit[cur.x]) continue;
            //System.out.println(cur.cost);
            visit[cur.x] = true;
            ans += cur.cost;
            if(++cnt == n+1) break;
            for(Node node : nodes[cur.x]){
                pq.add(node);
            }
        }
        System.out.println(ans);
    }

    static class Node implements Comparable<Node>{
        int x, cost;
        Node(int x, int cost){
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
