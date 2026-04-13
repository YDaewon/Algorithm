import java.io.*;
import java.util.*;

public class Main {
    static long x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        long z = (long) y * 100 / x;

        if(z >= 99){
            System.out.println(-1);
            return;
        }

        long l = 1;
        long r = x;

        while(l <= r){
            long mid = (l + r) / 2;
            // System.out.println(mid);
            if(z < (int) 100 * (y+mid) / (x + mid)){
                r = mid - 1;
            }
            else l = mid + 1;
        }

        System.out.println(l);
    }



}
