import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] nums = new int [n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int good = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int f = 0;
            int e = n-1;
            while(f < e){
                if(f == i) {
                    f++;
                    continue;
                }
                if(e == i) {
                    e--;
                    continue;
                }
                int mid = nums[f] + nums[e];
                if(nums[i] == mid) {
                    good++;
                    //System.out.println("nums[" + i + "] = " + nums[i]);
                    break;
                }
                else if(nums[i] < mid) e--;
                else f++;
            }
        }
        System.out.println(good);
    }

}