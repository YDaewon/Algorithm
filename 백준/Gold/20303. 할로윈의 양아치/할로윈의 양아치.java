import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Product{
        int v;
        int w;
        Product(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static int n;
    static int m;
    static int k;

    static int [] candy;
    static int [] parent;
    static int [] child_cnt;
    static List<Product> products;
    static int [][] dp;

    public static void main(String[] args) throws IOException {
        Input();
        solve();
    }

    static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        candy = new int[n+1];
        parent = new int[n+1];
        child_cnt = new int [n+1];
        products = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
            child_cnt[i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        for (int i = 1; i <= n; i++) {
            if (parent[i] != i) {
                int p = find(i);
                candy[p] += candy[i];
                child_cnt[p] += child_cnt[i];
            }
        }

        for(int i = 1; i <= n; i++){
            if(parent[i] == i) products.add(new Product(candy[i], child_cnt[i]));
        }
    }

    static int find(int a){
        if(a == parent[a]) return a;
        else {
            a = parent[a];
            return find(a);
        }
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    static void solve(){
        int N = products.size();
        //N = 인원, Vi = 물건 i의 가치, Wi = 물건 i의 비용, k = 가방의 무게

        dp = new int[N+1][k];  //[물건개수][무게]

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < k; j++) {
                if(j < products.get(i-1).w) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - products.get(i-1).w] + products.get(i-1).v);
            }
        }

        System.out.println(dp[N][k-1]);
    }
}