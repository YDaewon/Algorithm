import java.io.*;
import java.util.*;

public class Main {
    static int N, K, D;
    static Rule [] rule;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        rule = new Rule[K];
        int left = N;
        int right = 1;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            rule[i] = new Rule(A,B,C);
            left = Math.min(A, left);
            right = Math.max(B, right);
        }

        while(left <= right){
            int mid = (left + right) / 2;
            long sol = calc(mid);
            //System.out.println("left: " + left + ", right: " + right + ", mid: " + mid + ", sol: " + sol);
            if(sol >= D){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    static long calc(int num){
        long cnt = 0;
        for (Rule r : rule){
            if(r.max <= num){
                cnt += (r.max - r.min)/r.interval + 1;
            }
            else{
                int temp = num - r.min;
                if(temp >= 0)cnt += temp/r.interval + 1;
            }
        }
        return cnt;
    }

    static class Rule{
        int min;
        int max;
        int interval;

        public Rule(int min, int max, int interval) {
            this.min = min;
            this.max = max;
            this.interval = interval;
        }
    }

}