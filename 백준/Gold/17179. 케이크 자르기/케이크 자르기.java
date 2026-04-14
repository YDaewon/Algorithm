import java.io.*;
import java.util.*;

public class Main {
    static int n, m, l;
    static int [] cake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        cake = new int [m+1];
        for (int i = 0; i < m; i++) {
            cake[i] = Integer.parseInt(br.readLine());
        }
        cake[m] = l;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());

            int left = 0;
            int right = l;

            while(left <= right){
                int mid = (left + right) / 2;
                if(isPossible(mid, t)){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            sb.append(right).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPossible(int mid, int t) {
        int cnt = 0;
        int bef = 0;

        for (int i = 0; i <= m; i++) {
            if(cake[i] - bef >= mid){
                cnt++;
                bef = cake[i];
            }
        }

        return cnt > t;
    }
}
