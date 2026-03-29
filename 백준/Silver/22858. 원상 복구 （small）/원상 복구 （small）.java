 import java.io.*;
import java.util.*;

public class Main {
    static int n, k;

    static int [] d;

    /*
    S[i] = P[D[i]]

    P[D[i]] = S[i];
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int [] s = new int[n+1];
        int [] p = new int [n+1];
        d = new int [n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            for(int j = 1; j <= n; j++){
                p[d[j]] = s[j];
            }
            s = Arrays.copyOf(p, n+1);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(p[i] + " ");
        }
    }

}
