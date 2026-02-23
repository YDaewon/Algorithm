 import java.io.*;
import java.util.*;

public class Main {
    static int s, n, k;
    static int [] sp = new int [2];
    static int [] ep = new int [2];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        

        sp[0] = Integer.parseInt(st.nextToken());
        ep[0] = Integer.parseInt(st.nextToken());
        sp[1] = Integer.parseInt(st.nextToken());
        ep[1] = Integer.parseInt(st.nextToken());

        // 시간마다 n 제곱 만큼 커짐 -> n:3 이면 1 -> 9 -> 81
        // 중앙의 k * k 은 항상 검은색
        // s 시간 뒤 한 변 길이: n ^ s = len
        // s시간의 위치 y,x의 색깔: 
        // y >= (n / 2 - k / 2) && y <= (n / 2 + k / 2), x >= (n / 2 - k / 2) && x <= (n / 2 + k / 2) 이면 검정색
        // 밖이면 흰색
        // 검은색 범위내에는 전부검은색
        // 밖의 흰색에서는 작아진 사각형에서의 검은색을 또 체크
        // => 1까지 가면 젤 처음 사각형임 => 흰색
        long len = (long) Math.pow(n, s);
        

        for (int i = sp[0]; i <= ep[0]; i++) {
            for (int j = sp[1]; j <= ep[1]; j++) {
                sb.append(find(len, i, j));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int find(long len, long y, long x){
        if(len == 1) return 0;

        long nxt = len / n;
        long ty = y / nxt;
        long tx = x / nxt;

        long b = (n / 2 - k / 2);

        if(ty >= b  && ty < b + k && tx >= b && tx < b + k) return 1;

        return find(nxt, y % nxt, x % nxt);
    }

}
