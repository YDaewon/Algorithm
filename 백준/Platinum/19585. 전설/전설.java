 import java.io.*;
import java.util.*;

public class Main {
    static int c, n;
    static Trie trie;
    static String [] color;
    static Set<String> nickname;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        nickname = new HashSet<>();

        trie = new Trie();

        for (int i = 0; i < c; i++) {
            trie.insert(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            nickname.add(br.readLine());
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            if(trie.search(br.readLine())) sb.append("Yes").append("\n");
            else sb.append("No").append("\n");
        }

        System.out.println(sb);
    } 

    static class Trie{
        Letter root;

        Trie(){
            root = new Letter();
        }

        void insert(String str){
            Letter l = this.root;

            for(char c : str.toCharArray()){
                int i = c - 'a';
                if(l.next[i] == null) l.next[i] = new Letter(); 
                l = l.next[i];
            }
            l.isEnd = true;
        }

        boolean search(String str){
            Letter l = this.root;

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);

                l = l.next[c-'a'];
                if(l == null) break;

                if(l.isEnd){
                    if(nickname.contains(str.substring(i+1))) return true;
                }
            }
            return false;
        }
    }


    static class Letter{
        Letter [] next;
        boolean isEnd;

        Letter(){
            this.next = new Letter[26];
            this.isEnd = false;
        }
    }

}
