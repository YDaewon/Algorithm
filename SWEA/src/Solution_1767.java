import java.util.ArrayList;
import java.util.Scanner;
 

// SWEA 1767. 프로세서 연결하기
public class Solution_1767 {
 
    static int N; // 맵 사이즈
    static int[][] map; // 맥시노스 맵
    static ArrayList<Data> list;
    static int tCnt = 0; //시도해야할 총 코어갯수
    static int res;
    static int[] dx = {0,0,-1,1}; //상하좌우
    static int[] dy = {-1,1,0,0};
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int t =1; t <= TC; t++) {
            N = sc.nextInt();
            map = new int[N][N];
            list = new ArrayList<>();
            res = Integer.MAX_VALUE; //최소값 구하여 출력하기
            max = Integer.MIN_VALUE;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if(map[i][j]== 1){ //코어이면
                        if(i == 0 || i == N-1 || j == 0 || j == N-1) { //가장자리 코어는 충전할필요가 없음
                            continue;
                        }else {// 관리할 객체 목록에추가
                            list.add(new Data(j,i)); // i,j 조심 
                        }                       
                    }
                }
            } //입력 완료
            tCnt = list.size();
            //모든 코어를 부분집합으로 연결시도하기
            //연결된 코어 개수 세는 변수 필요함
            dfs(0, 0);
             
            System.out.println("#"+t + " " + res);
             
        }
 
    }
    static void dfs(int idx, int cnt) { //현재 코어 위치관리 idx, 연결된 코어갯수 cnt
        //가지치기 생각(남은 코어 다 연결해도 최대코어를넘어가지 못하면 나머지 코어 연결해 볼필요가 없음
        if(tCnt- idx + cnt < max) {
            return;
        }
         
        //최종코어이면 전선의 길이 구하여 최소값 구하기
        if(idx == tCnt) {
            int lCnt = getCount();
            //최대코어관리가 필요함
            if(max < cnt) {
                max = cnt;
                res = lCnt;
            }else if(max == cnt) {
                res = Math.min(res, lCnt);
            }
            return;
        }
        //현재 코어 넣기(4방향)
        Data cur = list.get(idx);
        int nx, ny;
        for(int d = 0; d< 4 ;d++) {
            //무조건 코어를 넣는것이 아니라 넣을수 있을때 넣기(백트래킹
            if(isAvaiable(cur.x, cur.y,d)) {
                //현재 코어를 d 방향으로 코어 전선 넣어보기
                connected(cur.x, cur.y, d, 2); //2는 전선으로 사용
                //재귀호출
                dfs(idx+1, cnt+1); //선택된 코어 세기필요함
                //현재 코어의 d 방향으로 넣은 코어 전선 회수하기(백트래킹) 
                connected(cur.x, cur.y, d, 0); //공백처리
            }
        }
        //현저 코어 안넣기
        dfs(idx+1, cnt);
    }
    private static int getCount() {
        int sum = 0;
        for(int i= 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 2) { //전선이면 세기
                    sum++;
                     
                }
            }
        }
        return sum;
    }
    private static void connected(int x, int y, int d, int z) {
        while(true) {
            x = x + dx[d];
            y = y + dy[d];
            if(x < 0 || x >= N || y < 0 || y >= N) {
                break;
            }
            map[y][x] = z;
        }
         
    }
    private static boolean isAvaiable(int x, int y, int d) {
        //현재 진행된 방향으로 0또는 N-1까지 0으로 되어 있으면  true, 그렇지 않으면 false;
        while(true) {
            x = x + dx[d];
            y = y + dy[d];
            //범위 벗어나면 연결이 가능함
            if(x < 0 || x >= N || y < 0 || y >= N) {
                break;
            }
            //장애물이 있으면 연결 안됨
            if(map[y][x] != 0) {
                return false;
            }
        }
        return true;
    }
    static class Data{
        int x, y;
        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}