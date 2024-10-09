import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] player = new int [100001];
        boolean [] card = new boolean [1000001];
        int [] score = new int [1000001];
        int max = 0;
        for(int i = 0; i < n;i++){
            int temp = Integer.parseInt(st.nextToken());
            card[temp] = true;
            player[i] = temp;
            max = Math.max(max, temp);
        }
        for (int i = 0; i < n; i++) {
            int now = player[i];
            for(int j = now *2; j <= max; j += now){
                if(card[j]){
                    score[now]++;
                    score[j]--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(score[player[i]] + " ");
        }
    }
}
