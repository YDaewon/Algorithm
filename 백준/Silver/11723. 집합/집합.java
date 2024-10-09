import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int bit = 0;
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num = 0;
			if(!str.equals("all") && !str.equals("empty"))
				num = Integer.parseInt(st.nextToken());
			switch(str) {
			case "add":
				bit |= (1<<num);
				break;
			case "remove":
				if((bit & 1 << num )> 0) bit -= 1<<num;
				break;
			case "check":
				sb.append(((bit & 1 << num) > 0 ? 1 : 0) + "\n");
				break;
			case "toggle":
				if((bit & 1 << num) > 0) bit -= 1<<num;
				else bit += 1<<num;
				break;
			case "all":
				bit = 0;
				for(int i = 1; i <= 20; i++) {
					bit += 1 << i;
				}
				break;
			case "empty":
				bit = 0;
				break;
			}	
		}
		System.out.println(sb.toString());
	}
}
