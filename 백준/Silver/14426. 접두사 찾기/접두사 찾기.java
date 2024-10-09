import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();
		for(int i = 0; i < n; i++) {
			String str = br.readLine().toString();
			trie.insert(str);
		}
		int ans = 0;
		for(int i = 0; i < m; i++) {
			String str = br.readLine().toString();
			if(trie.search(str)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}


class Node{
	Map<Character, Node> map = new HashMap<>();
	boolean eos = false;
	
}

class Trie{
	Node root = new Node();
	void insert(String str) {
		Node node = root;
		
		for(int i = 0; i < str.length();i++) {
			node.map.putIfAbsent(str.charAt(i), new Node());
			node = node.map.get(str.charAt(i));
		}
		node.eos = true;
	}
	
	boolean search(String str) {
		Node cur = root;
		for(int i = 0; i < str.length();i++) {
			//System.out.println("flag");
			Node now = cur.map.get(str.charAt(i));
			if(now == null) return false;
			cur = now;
		}
		return true;
	}
}
