import java.io.*;
import java.util.*;

public class Main {
    static int n;
    
    static List<Node> [] tree;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        tree = new List[n+1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new Node(b, c));
            tree[b].add(new Node(a, c));
        }

        Node end = find(1, -1);
        Node longest = find(end.x, -1);

        Node second1 = find(longest.x, end.x);
        Node second2 = find(end.x, longest.x);

        System.out.println(second1.cost > second2.cost ? second1.cost : second2.cost);


    }

    static Node find(int start, int not){
        Queue<Node> q = new LinkedList<>();
        boolean [] visit = new boolean[n+1];

        Node result = new Node(start, 0);
        visit[start] = true;
        q.add(result);

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(result.cost < cur.cost){
                result = cur;
            }

            for (Node nxt : tree[cur.x]) {
                if(nxt.x == not) continue;
                if(visit[nxt.x]) continue;
                q.add(new Node(nxt.x, cur.cost + nxt.cost));
                visit[nxt.x] = true;
            }
        }

        return result;
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
