 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Node [] tree;

    static int [] needs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            // 1. start input
            StringTokenizer st =new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            tree = new Node[n+1];
            needs = new int[n+1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                tree[v] = new Node();
                tree[v].beads = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                for (int j = 0; j < d; j++) {
                    int c = Integer.parseInt(st.nextToken());
                    tree[v].child.add(c);
                }
            }
            // end input

            // calc
            /*
            1. 각 정점 별로 몇개씩 필요한지를 체크
            1-1. 재귀로 마지막자식까지 간뒤 필요한 구슬 개수를 체크

            2. 배분
            
            */
            int root = find_root();

            calc(root);

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.abs(needs[i]);
            }
            System.out.println(cnt);
        }
    
    }


    /*
    현재 노드가 몇개나 필요한지 계산
    시작: 리프부터 가정
    1개 씩 필요함
    남으면 올려야됨
    */
    static int calc(int cur){
        int curhave = tree[cur].beads -1; // 지금 노드가 가지고 있는 구슬 개수(1개는 필요함)
        // 현재 노드가 0개를 가지고 있다면 다른 노드에서 구슬을 가져와야함: -1 이 반환

        for (int c : tree[cur].child) {
            curhave += calc(c); // 자식들의 계산 결과를 가져옴
        }
        
        // 현재 노드는 구슬이 ~~만큼 필요하다.
        // -1: 1개가 필요
        // 0: 필요없음
        // 1: 1개가 남음
        needs[cur] = curhave;

        return needs[cur];
    }

    static int find_root(){
        int root = 1;
        boolean [] t = new boolean [n+1];
        for (int i = 1; i <= n; i++) {
            for(int c : tree[i].child) t[c] = true;
        }

        for (int i = 1; i <= n; i++) {
            if(!t[i]) {
                root = i;
                break;
            }
        }
        return root;
    }

    static class Node{
        int beads;
        List<Integer> child = new ArrayList<>();
    }
}
