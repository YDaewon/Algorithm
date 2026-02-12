import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] pos = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pos.length; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pos);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int a = binary_search(s, pos);
            int b = ex_binary_search(e, pos);

            // a += (s == pos[a] ? 1 : 0);
            // b += (e == pos[b] ? 1 : 0);
            //System.out.println("a: " + a + ", b: " + b);
            sb.append((b - a) + "\n");
        }
        System.out.println(sb);
    }

    static int binary_search(int x, int [] pos){
        int left = 0;
        int right = pos.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(x > pos[mid])left = mid + 1;
            else right = mid;
        }

        return left;
    }

        static int ex_binary_search(int x, int [] pos){
        int left = 0;
        int right = pos.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(x >= pos[mid]) left = mid + 1;
            else right = mid;
        }

        return left;
    }

}
