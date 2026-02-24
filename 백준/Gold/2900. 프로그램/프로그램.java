 import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int [] a;
    static long [] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int t = Integer.parseInt(st.nextToken());
            temp.put(t, temp.getOrDefault(t, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> t : temp.entrySet()) {
            something(t.getKey(), t.getValue());
        }

        sum = new long [n];
        sum[0] = a[0];
        for (int j = 1; j < n; j++) {
            sum[j] = sum[j-1] + a[j];
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(sum[r] - sum[l] + a[l]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void something(int jump, int s) {
        int i = 0;
        while (i < n) {
            a[i] = a[i] + s;
            i = i + jump;
        }
    }

}
