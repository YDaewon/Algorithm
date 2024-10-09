import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int [] sushi = new int [N + k];
        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            if(i < k) sushi[N+i] = t;
            sushi[i] = t;
        }

        int ans = 0;
        boolean [] visit = new boolean[d+1];
        for (int left = 0; left < N; left++) {
            int cnt = 0;
            for(int right = left; right < left+k; right++){
               if (!visit[sushi[right]]) {
                   visit[sushi[right]] = true;
                   cnt++;
               }
            }
            if(!visit[c]) cnt++;
            ans = Math.max(ans, cnt);
            Arrays.fill(visit, false);
        }

        System.out.println(ans);
    }
}
