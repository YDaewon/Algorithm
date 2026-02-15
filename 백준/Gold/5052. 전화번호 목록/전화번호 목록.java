 import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            Set<Integer> s = new HashSet<>();
            boolean flag = false;

            String [] arr = new String[n];
            for (int c = 0; c < n; c++) {
                arr[c]= br.readLine();
            }
            Arrays.sort(arr);

            for (int i = 0; i < n-1; i++) {
                if(arr[i+1].startsWith(arr[i])){
                    flag = true;
                    break;
                }
            }
            if(flag) System.out.println("NO");
            else System.out.println("YES");
        }
    }

}
