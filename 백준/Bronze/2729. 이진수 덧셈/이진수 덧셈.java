import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            BigInteger t1 = new BigInteger(a, 2);
            BigInteger t2 = new BigInteger(b, 2);

            BigInteger ans = t1.add(t2);

            System.out.println(ans.toString(2));
        }
    }

}
