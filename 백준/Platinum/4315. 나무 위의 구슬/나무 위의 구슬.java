import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Node [] tree;

    static int [] need;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            tree = new Node[n+1];
            need = new int[n+1];

            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                tree[num] = new Node(cnt);
                for (int j = 0; j < d; j++) {
                    int child = Integer.parseInt(st.nextToken());
                    tree[num].child.add(child);
                }
            }

            int root = 1;
            boolean [] v = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                Node t = tree[i];
                for(int c : t.child){
                    v[c] = true;
                }
            }

            for (int i = 1; i <= n; i++) {
                if(!v[i]){
                    root = i;
                    break;
                }
            }

            go(root);

            int ans = 0;
            for (int i : need) {
                ans += i;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }

    private static int go(int now) {
        int cnt = tree[now].cnt - 1;

        for(int c : tree[now].child){
            cnt += go(c);
        }

        need[now] = Math.abs(cnt);

        return cnt;
    }

    static class Node{
        int cnt;
        List<Integer> child;

        Node(int cnt){
            this.cnt = cnt;
            this.child = new ArrayList<>();
        }
    }
}
