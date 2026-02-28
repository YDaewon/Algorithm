 import java.io.*;
import java.util.*;

public class Main {

    static int [] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        

        for(int C = 1; C <= T; C++) {
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            p = new int[n+1];

            for (int i = 0; i <= n; i++) p[i] = i;
            
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            int m = Integer.parseInt(br.readLine());
            sb.append("Scenario " + C + ":\n");
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(is_union(a, b) ? 1 : 0);
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int find(int a){
        if(a == p[a]) return a;
        return find(p[a]);
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) p[b] = a;
        else p[a] = b;
    }

    static boolean is_union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return true;

        return false;
    }
}
