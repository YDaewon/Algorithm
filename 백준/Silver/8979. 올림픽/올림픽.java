import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] answer = new int [4];

        List<int []> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int [] country = new int [4];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                country[j] = Integer.parseInt(st.nextToken());
                if (k == country[j]) answer[j] = country[j];
            }
            nums.add(country);
        }

        Collections.sort(nums, (n1, n2) -> {
            if(n1[1] != n2[1]) return n2[1] - n1[1];
            if(n1[2] != n2[2]) return n2[2] - n1[2];
            if(n1[3] != n2[3]) return n2[3] - n1[3];
            return 0;
        });

        if(nums.get(0)[0] == k){
            System.out.println(1);
            return;
        }

        int cnt = 1;
        for(int i = 1; i < n; i++){
            int [] bef = nums.get(i - 1);
            int [] cur = nums.get(i);
            if(bef[1] != cur[1] || bef[2] != cur[2] || bef[3] != cur[3]){
                cnt = i + 1;
            }
            if(cur[0] == k){
                break;
            }
        }
        System.out.println(cnt);
    }
}
