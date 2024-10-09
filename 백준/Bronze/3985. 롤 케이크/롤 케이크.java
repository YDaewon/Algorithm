import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int n = sc.nextInt();
		int [] arr = new int [L+1];
		int a=0, b=0, ans=0;
		int a_cnt = 0, b_cnt = 0;
		int idx = 1;
		for(int i = 1; i <= n;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			if(e-s > a_cnt) {
				a_cnt = e-s;
				a =  i;
			}
			int cnt = 0;
			for(int j = s; j <= e; j++) {
				if(arr[j] == 0) {
					arr[j] = i;
					cnt++;
				}
			}
			if(cnt > b_cnt) {
				b_cnt = cnt;
				b = i;
			}
		}
		System.out.println(a + "\n" + b);
	}
}
