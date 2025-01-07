import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static HashSet<Integer> set;
    static int n, m;
    static boolean [] visit;
    static int [] parent;
    public static void main(String[] args) throws IOException {//TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        parent = new int [n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(IsCycle(s, e)){
                if(ans == 0) ans = i+1;
            }
            else union(s, e);

        }
        System.out.println(ans);

    }

    private static boolean IsCycle(int s, int e) {
        if(find(s) == find(e)) return true;
        return false;
    }

    private static int find(int a){
        if(a == parent[a]) return a;
        else return find(parent[a]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        }
        else parent[a] = b;
    }

}