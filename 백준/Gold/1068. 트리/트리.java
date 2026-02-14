 import java.io.*;
import java.util.*;

public class Main {
    static int n, root, rm, answer = 0;
    static List<Integer> [] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1) root = i;
            else tree[p].add(i);
        }

        rm = Integer.parseInt(br.readLine());

        if(rm != root) bfs(root);

        System.out.println(answer);
    }

    static void bfs(int cur){
        if(tree[cur].isEmpty()) {
            answer++;
            return;
        }
        boolean f = true;
        for(int nxt : tree[cur]) {
            if(nxt != rm) {
                bfs(nxt);
                f = false;
            }
        }
        if(f) answer++;
    }
    
}
