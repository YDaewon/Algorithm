 import java.io.*;
import java.util.*;

public class Main {
    static int n, m, c, h, k;

    static int [] p;
    static int [] force;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int [n + 1];
        force = new int [n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            force[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x =Integer.parseInt(st.nextToken());
            union(y, x);

        }
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        c = find(c);
        h = find(h);

        // for (int i = 1; i <= n; i++) {
        //     System.out.print(p[i] + " ");
        // }
        // System.out.println();

        List<Integer> list = new ArrayList<>();

        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(i == find(i)){
                if(i == h || i == c) continue;
                list.add(force[i]);
            }
        }
        list.sort((o1,o2) -> o2 - o1);

        // for(int i = 0; i < list.size(); i++){
        //     System.out.print(list.get(i).getKey() + " " + list.get(i).getValue() + ", ");
        // }
        // System.out.println();
        
        int i = 0;
        while(i < list.size() && i < k){
            answer += list.get(i++);
        }
        System.out.println(answer + force[c]);
    }

    static int find(int a){
        if(a == p[a]) return a;
        else return find(p[a]);
    }

    static boolean union(int a ,int b){
        a = find(a);
        b = find(b);

        if(a == b) return true;
        
        if(a < b) {
            p[b] = a;
            force[a] += force[b];
        }
        else {
            p[a] = b;
            force[b] += force[a];
        }
        return true;
    }

}
