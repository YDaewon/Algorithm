import java.util.*;

public class Solution {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static List<Cell> dq;
    static PriorityQueue<Cell> pq;
    static boolean [][]visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 1; test <= T; test++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            dq = new ArrayList<>();
            pq = new PriorityQueue<>((p1, p2) -> p2.strength - p1.strength);
            visit = new boolean[n + (2 * k)][m + (2 * k)];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int t = sc.nextInt();
                    if (t != 0) {
                        dq.add(new Cell(i + k, j + k, t, t));
                        visit[i + k][j + k] = true;
                    }
                }
            }

            for (int time = 1; time <= k; time++) {
                while (!pq.isEmpty()) {
                    Cell temp = pq.poll();
                    if (!visit[temp.y][temp.x]) {
                        visit[temp.y][temp.x] = true;
                        dq.add(temp);
                        //System.out.println("add: " + temp.y + ", " + temp.x + ", " + temp.strength);
                    }
                }
                for (int i = 0; i < dq.size(); i++) {
                    if (dq.get(i).active == -1) continue;

                    if (dq.get(i).active == 0 && dq.get(i).time == time) {
                        dq.get(i).active = 1;
                        dq.get(i).time = time + dq.get(i).strength;

                        for (int j = 0; j < 4; j++) {
                            int y = dq.get(i).y + dy[j];
                            int x = dq.get(i).x + dx[j];

                            pq.add(new Cell(y, x, dq.get(i).strength, dq.get(i).strength + 1 + time));
                        }
                    } else if (dq.get(i).active == 1 && dq.get(i).time == time) {
                        dq.get(i).active = -1;
                    }
                }
            }
            int ans = 0;
            for (int t = 0; t < dq.size(); t++) {
                if (dq.get(t).active == -1) continue;
                //System.out.println(dq.get(t).active + " ");
                ans++;
            }
            //System.out.println();
            System.out.println("#" + test+ " " + ans);
        }
    }
    static class Cell{
        int y, x;
        int strength;
        int time;
        int active; // -1: dead, 0: non-active, 1: active
        Cell(int y, int x, int s, int t){
            this.y = y;
            this.x = x;
            this.strength = s;
            this.time = t;
            this.active = 0;
        }
    }
}
