 import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer> [] in, out;
    static boolean [] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        in = new List[n+1];
        out = new List[n+1];

        for (int i = 1; i <= n; i++) {
            in[i] = new ArrayList<>();
            out[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            in[b].add(a);
            out[a].add(b);
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            visit = new boolean[n+1];
            int cnt = 1;
            find(i, in);
            find(i, out);
            for(int j = 1; j <= n; j++) if(visit[j]) cnt++;
            // System.out.println("i: " + i + ", cnt: " + cnt);
            if(cnt == n) ans++;
        }

        System.out.println(ans);
    }   

    static void find(int now, List<Integer> [] list){
        for(int i : list[now]){
            if(visit[i]) continue;
            visit[i] = true;
            find(i, list);
        }
    }



}
