import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String [] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        int kbs1 = 0;
        int kbs2 = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i].equals("KBS1")){
                kbs1 = i;
            } else if(arr[i].equals("KBS2")){
                kbs2 = i;
            }
        }
        if(kbs2 > kbs1) kbs1++;

        for (int j = 0; j < kbs2; j++) sb.append("1");
        for (int j = 0; j < kbs2; j++) sb.append("4");
        for (int j = 0; j < kbs1; j++) sb.append("1");
        for (int j = 0; j < kbs1; j++) sb.append("4");

        System.out.println(sb.toString());
    }
}
