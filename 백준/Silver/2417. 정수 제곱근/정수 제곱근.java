import java.io.*;
import java.util.*;

public class Main {
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());

        long s = 0;
        long e = n;
        long ans = 0;

        while(s <= e){
            long mid = (s + e) / 2;

            if(Math.pow(mid,2) >= n){
                ans = mid;
                e = mid - 1;
            }
            else s = mid + 1;

        }

        System.out.println(ans);
    }
}
