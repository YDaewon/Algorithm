import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int [][] honey;
	static int n, m, c, ans;
	
	static int sum1, sum2;
	static int [][] visit;
	static boolean [] isselect;
	static List<Integer> A, B;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			init();
			sol(0);
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		c = sc.nextInt();
		ans = 0;
		visit = new int [n][n];
		honey = new int [n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				honey[i][j] = sc.nextInt();
			}
		}
		A = new ArrayList<>();
		B = new ArrayList<>();
	}
	
	static void sol(int d) {
		if(d == 2) {
			isselect = new boolean[m];
			sum1 = sum2 = 0;
			subset(0);
			ans = Math.max(sum1+sum2, ans);
			return;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(can_select(i,j)) {
					for(int x = j; x < j+m; x++) {
						visit[i][x] = d+1;
						if(d == 0) A.add(honey[i][x]);
						else if(d == 1) B.add(honey[i][x]);
					}
					sol(d+1);
					for(int x = j; x < j+m; x++) {
						visit[i][x] = 0;
						if(d == 0) A.remove(A.size()-1);
						else if(d == 1) B.remove(B.size()-1);
					}
				}
			}
		}
	}

	static void subset(int d) {
		if(d == m) {
			int csum1=0, csum2=0, msum1=0, msum2=0;
			for (int i = 0; i < m; i++) {
				if(isselect[i]){
					csum1 += A.get(i);
					msum1 += A.get(i) * A.get(i);
					csum2 += B.get(i);
					msum2 += B.get(i) * B.get(i);
				}
			}
			if(csum1 <= c) sum1 = Math.max(sum1, msum1);
			if(csum2 <= c) sum2 = Math.max(sum2, msum2);
			return;
		}
		isselect[d] = true;
		subset(d+1);
		isselect[d] = false;
		subset(d+1);
	}
	
	
	static boolean can_select(int y, int x) {
		for(int i = x; i < x+m;i++) {
			if(i >= n || visit[y][i] != 0)return false;
		}
		return true;
	}
}
