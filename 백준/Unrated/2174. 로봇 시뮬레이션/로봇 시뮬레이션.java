import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Main {
    static int A, B, N, M;
    static Robot [] robot;
    static int [][] map;
    static int [] dy = {1,0,-1,0};
    static int [] dx = {0,1,0,-1};
    static boolean flag = true;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [B+1][A+1];
        robot = new Robot [N+1];
        for (int i = 1; i <= N; i++) {
           st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           String d = st.nextToken();
           int t = 5;
           if(d.equals("N")) t = 0;
           else if(d.equals("E")) t = 1;
           else if(d.equals("S")) t = 2;
           else if(d.equals("W")) t = 3;
           robot[i] = new Robot(y,x,t);
           map[y][x] = i;
        }
        
        for(int i = 0; i < M; i++) {
        	 st = new StringTokenizer(br.readLine());
             int r = Integer.parseInt(st.nextToken());
             char q = st.nextToken().charAt(0);
             int j = Integer.parseInt(st.nextToken());
        	 if(flag == false) continue;
             if(q == 'F') {
	             for(int t = 0; t < j; t++) {
	            	 int ny = robot[r].y + dy[robot[r].d];
	            	 int nx = robot[r].x + dx[robot[r].d];
	            	 if(ny <= 0 || ny > B || nx <= 0 || nx > A)	{
	            		 System.out.println("Robot " + r + " crashes into the wall");
	            		 flag = false;
	            		 break;
	            	 }
	            	 else if(map[ny][nx] != 0) {
	            		 System.out.println("Robot " + r + " crashes into robot " + map[ny][nx]);
	            		 flag = false;
	            		 break;
	            	 }
	            	 else {
	            		 map[robot[r].y][robot[r].x] = 0;
	            		 robot[r].y = ny;
	            		 robot[r].x = nx;
	            		 map[robot[r].y][robot[r].x] = r;
	            	 }
	             }
             }
             else if(q == 'L') {
            	 for(int t = 0; t < j; t++) {
            		 robot[r].d = (robot[r].d + 3) % 4;
	             }
             }
             else if(q == 'R') {
            	 for(int t = 0; t < j; t++) {
            		 robot[r].d = (robot[r].d + 1) % 4;
	             }
             }
        }
        if(flag)System.out.println("OK");
    }
    
    static class Robot{
    	int y, x, d;
    	Robot(int y, int x, int d){
    		this.y = y;
    		this.x = x;
    		this.d = d;
    	}
    }
}