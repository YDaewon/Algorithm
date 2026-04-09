import java.io.*;
import java.util.*;

public class Main {
    static int k, m, p;
    static List<Integer> [] in;
    static List<Integer> [] out;
    static int [] save;
    static int [] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            in = new List [m+1];
            out = new List [m+1];
            save = new int [m+1];
            cnt = new int [m+1];

            int [] max = new int [m+1];
            int [] same_cnt = new int[m+1];

            for (int j = 1; j <= m; j++) {
                in[j] = new ArrayList<>();
                out[j] = new ArrayList<>();
            }

            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                out[s].add(e);
                in[e].add(s);
                cnt[e]++;
            }

            Queue<Integer> q = new LinkedList<>();

            for (int j = 1; j <= m; j++) {
                if(cnt[j] == 0) {
                    q.add(j);
                    max[j] = 1;
                }
            }

            while(!q.isEmpty()){
                int c = q.poll();

                if(same_cnt[c] > 1) save[c] = max[c] + 1;
                else save[c] = max[c];
                
                for(int nxt : out[c]){
                    if(save[c] > max[nxt]){
                        max[nxt] = save[c];
                        same_cnt[nxt] = 1;
                    }
                    else if(save[c] == max[nxt]){
                        same_cnt[nxt]++;
                    }

                    cnt[nxt]--;
                    if(cnt[nxt] == 0) q.add(nxt);
                }
            }
            // for (int j = 1; j <= m; j++) {
            //         System.out.print(save[j] + " ");
            // }
            // System.out.println();
            
            for (int j = 1; j <= m; j++) {
                if(out[j].isEmpty()){
                    System.out.println(k + " " + save[j]);
                    break;
                }
            }
        }

    }



}
