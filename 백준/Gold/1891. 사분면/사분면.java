import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * S(0) : moo
 * S(k) : S(k-1) + m + "o" * (k+2) + S(k-1)
 * 
 * S(k).length(): S(k-1).length * 2 + 1 + k+2
 */
public class Main {
	static int d;
	static char [] ans;
	static boolean flag = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken());
		ans = new char[d];
		long n = (long)Math.pow(2, d);
		char [] num = st.nextToken().toCharArray();
		st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());

		long size = n/2;
		for(char c : num) {
			if(c == '1' || c == '2') y += size;
			if(c == '4' || c == '1') x += size;
			size /= 2;
		}
		if(y >= 0 && x >= 0) {
			sol(d, y, x);
			if(flag) for(char c : ans) System.out.print(c);
			else System.out.println(-1);
		}
		else {
			System.out.println(-1);
		}
		
	}
	private static void sol(int depth, long y, long x) {
		if(depth == 0) return;
		//System.out.println(y + ", " + x);
		long half = (long)Math.pow(2, depth-1);
		if(y >= 0 && y < half *2 && x >= 0 && x < half *2) {
			if(y < half && x < half) {
				ans[d - depth] = '3';
				sol(depth-1, y, x);
			}
			else if(y < half && x >= half) {
				ans[d -depth] = '4';
				sol(depth-1, y, x - half);
			}
			else if (y >= half && x < half) {
				ans[d - depth] = '2';
				sol(depth-1, y - half, x);
			}
			else if (y >= half && x >= half) {
				ans[d - depth] = '1';
				sol(depth-1, y - half, x - half);
			}
			else {
				flag = false;
			}
		}
		else {
			flag = false;
		}
	}
	
}
