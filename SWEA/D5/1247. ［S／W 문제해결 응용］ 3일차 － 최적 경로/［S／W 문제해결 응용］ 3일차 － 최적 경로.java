import java.util.Scanner;

public class Solution {
	static Point [] p;
	static Point home, com;
	static int [] seq, visit;
	static int n, ans;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++){
            init();
			sol(1, 0);
			System.out.println("#" + i + " " + ans);
        }
	}
	
	static void init() {
		n = sc.nextInt();
		int y= sc.nextInt();
		int x= sc.nextInt();
		com = new Point(y,x);
		y = sc.nextInt();
		x = sc.nextInt();
		home = new Point(y,x);
		p = new Point[n+1];
		seq = new int[n+1];
		visit = new int[n+1];
		for(int i = 1; i <= n; i++) {
			y = sc.nextInt();
			x = sc.nextInt();
			p[i] = new Point(y,x);
		}
		ans = Integer.MAX_VALUE;
	}
	
	static void sol(int d, int sum) {
		if (sum > ans) return;
		if(d == n+1) {
			//for(int i : seq) System.out.print(i + " ");
			//System.out.println();
			sum += get_distance(p[seq[n]], home);
			ans = Math.min(sum, ans);
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(visit[i] == 0) {
				seq[d] = i;
				visit[i] = 1;
				if(d > 1) sol(d+1, sum + get_distance(p[seq[d]], p[seq[d-1]]));
				else sol(d+1, sum + get_distance(com, p[seq[d]]));
				visit[i] = 0;
			}
		}
	}
	
	static int get_distance(Point p1, Point p2) {
		return Math.abs(p1.y-p2.y) + Math.abs(p1.x - p2.x);
	}
	
	static class Point{
		int y,x;
		Point(){
			this.y = 0;
			this.x = 0;
		}
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
