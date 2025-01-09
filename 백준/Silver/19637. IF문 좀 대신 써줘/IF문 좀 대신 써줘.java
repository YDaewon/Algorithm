import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashSet<Integer> set;
    static int n, m;
    static Title [] title;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        title = new Title[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = new Title(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(br.readLine());
            print(t);
        }
    }

    static void print(int num){
        int l = 0;
        int r = n;
        while(l < r){
            int mid = (l + r) / 2;
            if(title[mid].num < num){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        System.out.println(title[l].name);
    }

    static class Title{
        int num;
        String name;

        public Title(String name, int num) {
            this.num = num;
            this.name = name;
        }
    }
}