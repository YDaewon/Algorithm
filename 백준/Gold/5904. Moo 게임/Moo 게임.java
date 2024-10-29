import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * S(0) : moo
 * S(k) : S(k-1) + m + "o" * (k+2) + S(k-1)
 * 
 * S(k).length(): S(k-1).length * 2 + 1 + k+2
 */
public class Main {
	static char ans;
	static int [] len;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		len = new int [30];
		len[0] = 3;
		int size = len[0];
		int k = 1;
		while(n > size) {
			size = size*2 + k + 3;
			len[k++] = size;
		}
		k--;
		//System.out.println(k);
		get_char(k, n);
		System.out.println(ans);
	}
	private static void get_char(int k, int now) {
		if(k == 0) {
			if(now == 1) ans = 'm';
			else ans = 'o';
			return;
		}
		if(now > len[k-1] + k + 3) {
			//System.out.println("뒷쪽 k-1, now: " + (now - (len[k-1] + k + 3)));
			get_char(k-1, now - (len[k-1] + k + 3));
		}
		else if(now <= len[k-1]) {
			//System.out.println("앞쪽 k-1, now: " + now);
			get_char(k-1, now);
		}
		else {
			//System.out.println("중간");
			get_char(0, now - len[k-1]);
		}
	}
	
}
