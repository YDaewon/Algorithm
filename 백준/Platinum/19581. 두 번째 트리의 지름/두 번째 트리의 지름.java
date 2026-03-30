 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Node> [] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new List[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tree[s].add(new Node(s, e, cost));
            tree[e].add(new Node(e, s, cost));
        }

        Node start2root = find(1, -1);
        Node root2most = find(start2root.e, -1);

        Node second2most = find(root2most.e, root2most.s);
        Node most2second = find(root2most.s, root2most.e);

        System.out.println(second2most.cost < most2second.cost ? most2second.cost : second2most.cost);
    }

    static Node find(int start, int not){
        boolean [] visit = new boolean[n+1];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(start, start, 0));
        visit[start] = true;

        Node result = new Node(start,start,0);

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(result.cost < cur.cost && cur.e != not){
                result = new Node(start, cur.e, cur.cost);
            }

            for (Node nxt : tree[cur.e]) {
                if(nxt.e == not) continue;
                if(!visit[nxt.e]){
                    visit[nxt.e] = true;
                    q.add(new Node(nxt.s, nxt.e, cur.cost + nxt.cost));
                }
            }
        }

        return result;
    }

    static class Node{
        int s;
        int e;
        int cost;

        Node(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}
