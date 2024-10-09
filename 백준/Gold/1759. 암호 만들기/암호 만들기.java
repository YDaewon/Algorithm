import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char [] arr;
	static int L, C;
	static boolean [] visited;
	static char [] aeiou = {'a','e','i','o','u'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        
        arr = new char[C];
        visited = new boolean[C];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        combination(0,0);
	}
	
	static void combination(int d, int cur) {
		if(d == L) {
			String ans = "";
			for(int i = 0; i < C; i++) {
				if(visited[i]) ans+= arr[i];
			}
			if(check(ans))System.out.println(ans);
			return;
		}
		for(int i = cur; i < C; i++) {
				visited[i] = true;
				combination(d+1, i+1);
				visited[i] = false;
		}
	}
	
	static boolean check(String str) {
		int a = 0, b = 0;
		for(int i = 0; i < L; i++) {
			boolean flag = true;
			for(int j = 0; j < 5; j++) {
				if(str.charAt(i) == aeiou[j]) {
					a++;
					flag = false;
					break;
				}
			}
			if(flag) b++;
		}
		if(a >= 1 && b >= 2) return true;
		return false;
	}
}
