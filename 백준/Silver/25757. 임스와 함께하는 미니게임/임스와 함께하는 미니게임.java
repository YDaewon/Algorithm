import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int need_player = 0;
        if(game == 'Y') need_player = 2;
        else if(game == 'F') need_player = 3;
        else need_player = 4;
        Set<String> user = new HashSet<>();
        for (int i = 0; i < n; i++) {
            user.add(br.readLine());
        }
        int len = user.size();
        System.out.println(len / (need_player - 1));
    }

}
