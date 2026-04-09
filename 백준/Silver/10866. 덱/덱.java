import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                dq.addFirst(num);
            }
            else if(cmd.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
            }
            else if(cmd.equals("pop_front")){
                int num = dq.isEmpty() ? -1 : dq.pollFirst();
                sb.append(num).append("\n");
            }
            else if(cmd.equals("pop_back")){
                int num = dq.isEmpty() ? -1 : dq.pollLast();
                sb.append(num).append("\n");
            }
            else if(cmd.equals("size")){
                sb.append(dq.size()).append("\n");
            }
            else if(cmd.equals("empty")){
                sb.append(dq.isEmpty() ? 1 : 0).append("\n");
            }
            else if(cmd.equals("front")){
                int num = dq.isEmpty() ? -1 : dq.peekFirst();
                sb.append(num).append("\n");
            }
            else if(cmd.equals("back")){
                int num = dq.isEmpty() ? -1 : dq.peekLast();
                sb.append(num).append("\n");                
            }
        }
        System.out.println(sb);
    }
}
