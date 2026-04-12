import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static Trie trie = new Trie();

    static int [] dy = {-1,-1,-1,0,0,1,1,1};
    static int [] dx = {-1,0,1,-1,1,-1,0,1};

    static char [][] map;
    static boolean [][] visit;

    static Set<String> ans_str;
    static int cnt;
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            trie.insert(str);
        }
        br.readLine();
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            map = new char[4][4];
            visit = new boolean[4][4];
            ans_str = new HashSet<>();
            cnt = 0;
            score = 0;

            for (int i = 0; i < 4; i++) {
                map[i] = br.readLine().toCharArray();
            }

            
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    if(trie.root.child[map[i][j] - 'A'] == null) continue;

                    visit[i][j] = true;
                    dfs(1, i, j, String.valueOf(map[i][j]), trie.root.child[map[i][j] - 'A']);
                    visit[i][j] = false;
                }
            }
            String answer = "";
            for(String str : ans_str){
                cnt++;
                int d = str.length();
                if(answer.length() < d) answer = str;
                else if(answer.length() == d){
                    if(str.compareTo(answer) < 0) answer = str;
                }

                if(d == 8) score += 11;
                else if(d == 7) score += 5;
                else if(d == 6) score += 3;
                else if(d == 5) score += 2;
                else if(d > 2) score += 1; 
            }

            sb.append(score).append(" ").append(answer).append(" ").append(cnt).append("\n");
            br.readLine();
        }

        System.out.println(sb);
    }

    private static void dfs(int d, int y, int x, String str, Node node) {
        if(d > 8) return; 

        if(node.isEnd){
            ans_str.add(str);
        }

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= 4 || nx < 0 || nx >= 4) continue;

            if(!visit[ny][nx] && node.child[map[ny][nx] - 'A'] != null){
                visit[ny][nx] = true;
                dfs(d+1, ny, nx, str+map[ny][nx], node.child[map[ny][nx] - 'A']);
                visit[ny][nx] = false;
            }
        }
    }



    static class Trie{
        Node root = new Node();

        void insert(String str){
            Node cur = root;
            
            for(char c : str.toCharArray()){
                if(cur.child[c - 'A'] == null) cur.child[c - 'A'] = new Node();
                cur = cur.child[c-'A'];
            }
            cur.isEnd = true;
        }

        boolean search(String str){
            Node cur = root;
            
            for(char c : str.toCharArray()){
                if(cur.child[c - 'A'] == null) return false;
                cur = cur.child[c-'A'];
            }

            return cur.isEnd;
        }

    }

    static class Node{
        Node [] child = new Node [26];
        boolean isEnd = false;
    }

}
