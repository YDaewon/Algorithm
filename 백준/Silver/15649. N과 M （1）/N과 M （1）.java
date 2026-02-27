 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static boolean [] visit = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        calc(0, new ArrayList<>());

        System.out.println(sb);

    }

    static void calc(int d, List<Integer> cur){
        if(d >= m){
            for(int i : cur){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visit[i]){
                visit[i] = true;
                cur.add(i);
                calc(d+1, cur);
                cur.remove(cur.size()-1);
                visit[i] = false;
            }
        }
    }
}
