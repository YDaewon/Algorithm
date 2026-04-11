import java.io.*;
import java.util.*;

public class Main {
    static int n, t;
    static List<Integer> [] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        pos = new List[t+1];
        for (int i = 0; i <= t; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[y].add(x);
        }


        System.out.println(bfs());
    }

    static int bfs(){
        Queue<int []> q = new LinkedList<>();

        q.add(new int [] {0, 0, 0});

        while(!q.isEmpty()){
            int [] c = q.poll();

            if(c[0] == t) return c[2];

            for (int i = c[0] - 2; i <= c[0] + 2; i++) {
                if(i < 0 || i > t) continue;
                for (int j = 0; j < pos[i].size(); j++) {
                    int nx = pos[i].get(j);

                    if(Math.abs(nx - c[1]) <= 2){
                        q.add(new int [] {i, nx, c[2] + 1});
                        pos[i].remove(j);
                        j--;
                    }
                }
            }
        }

        return -1;
    }

}
