import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int [] nums = new int [n];
        int [] sums = new int [n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(i == 0) sums[i] = nums[i];
            else sums[i] = sums[i-1] + nums[i];

          //  System.out.println((i-x) + " , sums[" + i + "] = " + sums[i]);
        }

        int max = sums[x-1];
        int cnt = 1;
        for (int i = x; i < n; i++) {
            int cur = sums[i] - sums[i-x];
          //  System.out.println("now idx: " + i + ", cur: " + cur);
            if(cur > max){
                max = cur;
                cnt = 1;
            }
            else if(cur == max) cnt++;
        }

        if(max != 0){
            System.out.println(max);
            System.out.println(cnt);
        }
        else System.out.println("SAD");
    }

}