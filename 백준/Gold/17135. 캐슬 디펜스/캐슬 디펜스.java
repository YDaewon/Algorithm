import java.util.Scanner;
 
public class Main {
    static int N, M, D;
    static int[][] map;
    static int[][] copymap;
    static int ans;
    static int [] archer = new int [3];
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
       
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
 
        map = new int[N + 1][M + 1];
        copymap = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                copymap[i][j] = map[i][j] = sc.nextInt();
            }
        }
        ans = 0;
        comb(1, 0);
 
        System.out.println(ans);
    }
 

    public static void init() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = copymap[i][j];
            }
        }
    }
 

    public static int distance(int r1, int r2, int c1, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
 

    public static void comb(int start, int d) {
        if (d == 3) {
            init();
            attack();
            return;
        }
 
        for (int i = start; i <= M; i++) {
            archer[d] = i;
            comb(i + 1,d+1);
        }
    }
 
    public static void attack() {
        int res = 0;
 
        for (int n = 1; n <= N; n++) {
            boolean[][] visited = new boolean[N + 1][M + 1];
            
            for (int k = 0; k < 3; k++) {
                int temp = archer[k]; 
                int minD = Integer.MAX_VALUE;
                int minR = Integer.MAX_VALUE;
                int minC = Integer.MAX_VALUE;
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        if (map[i][j] == 1) { 
                        	int t = distance(i, N + 1, j, temp);
                            if (minD >= t) {
                                if (minD > t) {
                                    minD = t;
                                    minR = i;
                                    minC = j;
                                } else {
                                    if (minC > j) {
                                        minR = i;
                                        minC = j;
                                    }
                                }
                            }
                        }
                    }
                }
                if (minD <= D) {
                    visited[minR][minC] = true;
                }
            }
            
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (visited[i][j]) {
                        map[i][j] = 0;
                        res++;
                    }
                }
            }
            
            for (int i = 1; i <= M; i++) {
                map[N][i] = 0;
            }
            
            for (int i = N; i >= 1; i--) {
                for (int j = 1; j <= M; j++) {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        ans = Math.max(ans, res);
    }
 
}