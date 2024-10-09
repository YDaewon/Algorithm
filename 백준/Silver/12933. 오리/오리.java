import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char [] str = sc.nextLine().toCharArray();
		char [] quack = {'q', 'u','a','c','k'};
		int sz = str.length;
		int cnt = 0;
		
		int checkq = sz;
		int k = 0;
		List<Integer> temp = new ArrayList<>();
		if(sz % 5 == 0) {
			for(int i = 0; i < sz; i++) {
				if(str[i] != 'q') continue;
				boolean flag = false;
				for(int j = i; j < sz; j++) {
					if(str[j] == quack[k]) {
						k++;
						temp.add(j);
					}
					if(k == 5) {
						k = 0;
						flag = true;
					}
				}
				if(flag) {
					cnt++;
					for(int t : temp) {
						str[t] = '.';
						checkq--;
					}
					temp.clear();
				}
				//System.out.println(String.copyValueOf(str));
			}
		}
		System.out.println(checkq != 0 ? -1 : cnt);
	}
}
