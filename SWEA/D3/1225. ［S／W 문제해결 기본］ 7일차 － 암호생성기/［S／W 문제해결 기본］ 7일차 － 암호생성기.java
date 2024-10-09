import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int T = 1; T < 11; T++){
            int n = sc.nextInt();
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                q.add(sc.nextInt());
            }
            int t = 1;
            int temp;
            while (true){
                temp = q.pollFirst() - t;
                q.addLast(temp >= 0 ? temp : 0);
                t++;
                if(t > 5 ) t = 1;
                if(q.peekLast() <= 0) break;
            }
            System.out.print("#" + T + " ");
            for(int i : q) System.out.print(i + " ");
            System.out.println();
        }
    }
}
