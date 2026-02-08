import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] a = new int [n * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) a[i] = Integer.parseInt(st.nextToken());

        int ans = sim(n, k, a);
        System.out.println(ans);
    }

    static int sim(int n, int k, int [] belt){
        int len = 2 * n;
        boolean [] robot = new boolean [n]; // 로봇 위치
        int cycle = 1;
        while(true){
            //step 1
            int temp = belt[len-1];
            for (int i = len-1; i > 0; i--) {
                belt[i] = belt[i-1];
                if(i < n) robot[i] = robot[i-1];
            }
            belt[0] = temp;
            robot[n-1] = false;
            robot[0] = false;
//            {
//                for (int i = 0; i < n; i++) {
//                    System.out.print(belt[i] + " ");
//                }
//                System.out.println();
//                for (int i = len - 1; i >= n; i--) {
//                    System.out.print(belt[i] + " ");
//                }
//                System.out.println();
//            }
            // step2
            for (int i = n-1; i > 1; i--) {
                if(robot[i-1] && !robot[i] && belt[i] > 0){
                    robot[i] = true;
                    robot[i-1] = false;
                    --belt[i];
                }
            }
            robot[n-1] = false;
            //step3
            if(belt[0] > 0) {
                robot[0] = true;
                --belt[0];
            }
//            System.out.print("robot pos: ");
//            for (int i = 0; i < n; i++) {
//                System.out.print((robot[i] ? 1 : 0) + " ");
//            }
//            System.out.println();
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if(belt[i] == 0) cnt++;
            }
            if(cnt >= k) break;
            cycle++;
        }

        return cycle;
    }
}
