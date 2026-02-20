 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean [] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        next_permutation(0, 0);
    }

    static void next_permutation(int d, int now){
        if(d == m){
            for (int i = 1; i <= n; i++) {
                if(visit[i]) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = now + 1; i <= n; i++) {
            if(!visit[i]){
                visit[i] = true;
                next_permutation(d+1, i);
                visit[i] = false;
            }
        }
    }

}
