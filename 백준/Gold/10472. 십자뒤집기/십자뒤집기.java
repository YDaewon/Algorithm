 import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static int ans;

    static int [][] change ={
        {0,1,3},
        {0,1,2,4},
        {1,2,5},
        {0,3,4,6},
        {1,3,4,5,7},
        {2,4,5,8},
        {3,6,7},
        {4,6,7,8},
        {5,7,8}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        while(n-- > 0){
            int start = 0;

            int end = 0;
            for (int i = 0; i < 3; i++) {
                char [] temp = br.readLine().toCharArray();
                for (int j = 0; j < 3; j++) {
                    if(temp[j] == '*') end += 1 << (i * 3 + j);
                }
            }
            ans = bfs(start, end);

            System.out.println(ans);

        }

    }

    static int bfs(int start, int end){
        boolean [] visit = new boolean[(int)(Math.pow(2, 9))];
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {start, 0});
        visit[0] = true;
        while(!q.isEmpty()){
            int [] cur = q.poll();

            if(cur[0] == end) return cur[1];

            for (int i = 0; i < 9; i++) {
                int nxt = cur[0];
                for (int c : change[i]) {
                    if((nxt & (1 << c)) != 0){
                        nxt -= (1 << c);
                    }
                    else{
                        nxt += (1 << c);
                    }
                }
                if(!visit[nxt]){
                    visit[nxt] = true;
                    q.add(new int [] {nxt, cur[1] + 1});
                }
            }
        }

        return -1;
    }
}
