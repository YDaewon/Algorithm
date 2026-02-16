 import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int [][] consult;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        consult = new int [n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            consult[i][0] = Integer.parseInt(st.nextToken());
            consult[i][1] = Integer.parseInt(st.nextToken());
        }
        
        calc(0, 0);

        System.out.println(answer);
    }

    static void calc(int d, int sum){
        if(d > n) return;
		if(d == n) {
			answer = Math.max(answer, sum);
			return;
		}

        calc(d + consult[d][0], sum + consult[d][1]);
        calc(d + 1, sum);
    }
}
