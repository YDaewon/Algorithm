import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static List<Integer> [] tree;
    static int [] times;
    static int [] child;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList [n];
        times = new int[n];
        child = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if(boss == -1) continue;
            tree[boss].add(i);
        }
        // find_child(0);
        // for (int i = 0; i < n; i++) {
        //     System.out.println(i + " child: " + child[i]);
        // }

        System.out.println(dfs(0));
    }

    // 밑에서부터 올라오기
    //    a
    //   b   c
    // d e f  g
    //
    // d e f => 0초 씀(말단)
    // b: 3초 씀(전달할 사람이 3명)
    // c: 1초 씀
    // c를 먼저주면 b가 전부 1초 씩 밀림 -> b 먼저 주기

    /*
    child 수가 오래 걸리는 수가 아니었음. 반례: 예제 4
    */
    // static int find_child(int cur){
    //     for (int nxt : tree[cur]) {
    //         child[cur] += find_child(nxt);
    //     }
    //     return child[cur]+1;
    // }


    static int dfs(int cur){
        if(tree[cur].isEmpty()) return 0;

        List<Integer> t = new ArrayList<>();
        for (int nxt : tree[cur]) {
            t.add(dfs(nxt));
        }

        Collections.sort(t, Collections.reverseOrder());
        for(int i = 0; i < t.size(); i++) times[cur] = Math.max(times[cur], t.get(i) + i + 1);

        return times[cur];
    }
    
}
