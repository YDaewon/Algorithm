import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        

        int l = 1;
        int r = 1;
        int sum = 1;

        int ans = 0;
        while(l <= r){
            if(sum < n){
                r++;
                sum += r;
            }
            else{
                if(sum == n) ans++;
                sum -= l;
                l++;
            }

            //System.out.println("sum: "+ sum + ", l: " + l + ", r: " + r);
        }
        System.out.println(ans);
    }
}
