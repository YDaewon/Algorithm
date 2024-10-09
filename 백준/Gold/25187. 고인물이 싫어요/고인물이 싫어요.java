import java.io.*;
import java.util.*;

/*
BOJ - 25187
메모리 - 313976Kb
시간 - 1876 ms
*/
public class Main {
    static int [] water, p;
    static int N,M,Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        water = new int[N+1];
        p = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            water[i] = Integer.parseInt(st.nextToken()) == 1 ? 1 : -1;;
            p[i] = i;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            union(f, s);
        }

        while(Q-- != 0) {
            int v = Integer.parseInt(br.readLine());
            sb.append((water[find(v)] > 0 ? 1: 0) + "\n");
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if(x==p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b= find(b);
        if(a == b) return;
        if(a < b) {
            water[a] += water[b];
            p[b] = a;
        }
        else {
            water[b] += water[a];
            p[a] = b;
        }
    }


}