import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int [] home = new int [n];
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            home[i] = t;
        }
        Arrays.sort(home);

        int left = 1;
        int right = home[n-1];
        while(left <= right){
            //System.out.println("left: " + left + ", right: " + right);
            int mid = (left + right) / 2;

            if(calc(home, c, mid)){
                left = mid + 1;
            }
            else right = mid - 1;
        }

        System.out.println(right);
    }

    static boolean calc(int [] home, int c, int m){
        int bef = home[0];
        int wifi = 1;
        for (int i = 1; i < home.length; i++) {
            if(home[i] - bef >= m) {
                wifi++;
                bef = home[i];
            }
        }
        if(wifi < c) return false;
        else return true;
    }

}