import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> rank = new ArrayList<>();
       // rank.add(score);
        if(n > 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rank.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(rank, Collections.reverseOrder());

        int cnt = 0;
        int same = 0;
        for (int i = 0; i < n; i++) {
            if(score < rank.get(i)) {
                cnt++;
            }
            else if (score == rank.get(i)){
                same++;
            }
            else break;
        }

        // 실제 랭킹: 나보다 큰거 + 같은거 개수
        // 표기 랭킹: 나보다 큰거

        if(cnt + same >= p) {
            //System.out.println("cnt: " + cnt + ", same: " + same);
            System.out.println(-1);
        }
        else System.out.println(cnt + 1);
    }

}
