import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Biz [] tree;
    static int [] need;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            boolean [] flag = new boolean[n+1];
            tree = new Biz [n+1];
            need = new int [n+1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int biz_cnt = Integer.parseInt(st.nextToken());
                tree[v] = new Biz(biz_cnt);
                int d = Integer.parseInt(st.nextToken());

                for (int j = 0; j < d; j++) {
                    int t = Integer.parseInt(st.nextToken());
                    flag[t] = true;
                    tree[v].child.add(t);
                }
            }
            int root = 1;
            for(int j = 1; j <= n; j++){
                if(!flag[j]) {
                    root = j;
                    break; 
                }
            }

            count(root);
            int ans = 0;
            for(int t : need) ans += t;
            sb.append(ans).append("\n");     
        }
        System.out.println(sb);
    }


    static int count(int cur){
        int c = tree[cur].cnt - 1;
        for (int i : tree[cur].child) {
            c += count(i);
        }
        need[cur] = Math.abs(c);

        return c;
    }


    static class Biz{
        int cnt;
        List<Integer> child;

        Biz(int cnt){
            this.cnt = cnt;
            this.child = new ArrayList<>();
        }
    }
}
