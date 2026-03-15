 import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> s = new ArrayDeque();

        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            if(query.equals("push")){
                int t = Integer.parseInt(st.nextToken());
                s.push(t);
            }
            else if(query.equals("pop")){
                if(s.isEmpty()){
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(s.pop()+"\n");
            }
            else if(query.equals("size")){
                sb.append(s.size()+"\n");
            }
            else if(query.equals("empty")){
                sb.append((s.isEmpty() ? 1 : 0) + "\n");
            }
            else if(query.equals("top")){
                if(s.isEmpty()){
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(s.peek()+"\n");
            }
        }

        System.out.println(sb);
    } 

}
