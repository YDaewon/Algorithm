import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0;
        boolean [] nums = new boolean[100001];
        int e = 0;
        for (int s = 0; s < n; s++) {
            while(e < n && !nums[arr[e]]) {
//                for (int j = s; j <= e; j++) {
//                    System.out.print(arr[j] + ", ");
//                }
//                System.out.println();
                nums[arr[e++]] = true;
            }
            cnt += e - s;
            nums[arr[s]] = false;
        }
        System.out.println(cnt);
    }
}