import java.util.*;

public class Main {
    
    static List<Integer>[] node;
    static Set<Integer> numSet;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();
        
        node = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            node[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            node[a].add(b);
            node[b].add(a);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(node[i]);
        }
        
        numSet = new HashSet<>();
        dfs(v);
        System.out.println();
        
        numSet = new HashSet<>();
        bfs(v);
    }
    
    public static void dfs(int num) {
        System.out.print(num + " ");
        numSet.add(num);
        for (int idx : node[num]) {
            if (!numSet.contains(idx)) {
                dfs(idx);
            }
        }
    }
    
    public static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        numSet.add(num);
        
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for (int idx : node[x]) {
                if (!numSet.contains(idx)) {
                    q.add(idx);
                    numSet.add(idx);
                }
            }
        }
    }
}