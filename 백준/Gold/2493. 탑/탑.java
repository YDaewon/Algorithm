import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Pair2493> s = new Stack<>();
        s.push(new Pair2493(100000001, 0));
        for(int i = 1; i<= n;i++){
            int temp = Integer.parseInt(st.nextToken()); //탑 하나 받고
            while(s.peek().value < temp) s.pop(); // 받은 탑보다 높은 탑 나올때 까지 pop
            sb.append(new String(s.peek().idx + " ")); //while문이 끝나면 높은탑이니 그 탑의 인덱스 추가
            s.push(new Pair2493(temp, i)); // 지금 탑 추가
        }
        System.out.println(sb.toString());
    }
}

class Pair2493{
    int value, idx;
    public Pair2493(int v, int i){
        value= v;
        idx = i;
    }
}