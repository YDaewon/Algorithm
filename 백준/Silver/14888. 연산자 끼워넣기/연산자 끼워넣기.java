import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] nums;
    static int [] oper = new int [4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        nums = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) oper[i] = Integer.parseInt(st.nextToken());

        calc(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void calc(int d, int val){
        // System.out.println("d: " + d + ", val: " + val);
        if(d == n){
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(oper[i] != 0){
                oper[i]--;
                switch(i){
                    case 0:
                        calc(d + 1, val + nums[d]);
                        break;
                    case 1:
                        calc(d + 1, val - nums[d]);
                        break;
                    case 2:
                        calc(d + 1, val * nums[d]);
                        break;
                    case 3:
                        calc(d + 1, val / nums[d]);
                        break;
                }
                oper[i]++;
            }
        }
    }

}
