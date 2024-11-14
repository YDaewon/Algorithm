import java.util.Scanner;

public class Main {
	static int n,ans = 0;
	static int [][] cal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cal = new int [n][2];
		for(int i = 0 ; i < n ; i++) {
			int t = sc.nextInt();
			int p = sc.nextInt();
			cal[i][0] = t;
			cal[i][1] = p;
		}
		sol(0,0);
		System.out.println(ans);
	}
	
	static void sol(int day, int sum) {
		if(day > n) return;
		if(day == n) {
			ans = Math.max(ans, sum);
			return;
		}
		sol(day+cal[day][0], sum + cal[day][1]);
		sol(day+1, sum);
	}
}
