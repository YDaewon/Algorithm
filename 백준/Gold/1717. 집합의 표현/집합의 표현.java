 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static int [] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int [n+1];

        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m;i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd == 0) union(a,b);
            else if(find(a) == find(b)) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }

    static int find(int a){
        if(a ==p[a]) return a;
        return p[a] = find(p[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) p[b] = a;
        else p[a] = b;
    }


}
