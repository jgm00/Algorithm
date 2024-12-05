import java.io.*;
import java.util.*;

public class Main {

	static int N;

	static String[] lc;
	static String[] rc;
	static String[] parent;
	static HashMap<String, Integer> map = new HashMap<>();

	static int CtoI(String s) {
		return s.charAt(0) - 'A' + 1;
	}

	static void preorder(String root) {
		System.out.print(root);
		int k = map.get(root);
		if (!lc[k].equals(".")) {
			preorder(lc[k]);
		}
		if (!rc[k].equals(".")) {
			preorder(rc[k]);
		}
	}

	static void inorder(String root) {
		int k = map.get(root);
		if (!lc[k].equals(".")) {
			inorder(lc[k]);
		}
		System.out.print(root);
		if (!rc[k].equals(".")) {
			inorder(rc[k]);
		}
	}

	static void postorder(String root) {
		int k = map.get(root);
		if (!lc[k].equals(".")) {
			postorder(lc[k]);
		}
		if (!rc[k].equals(".")) {
			postorder(rc[k]);
		}
		System.out.print(root);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lc = new String[N + 1];
		rc = new String[N + 1];
		parent = new String[N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			String l = st.nextToken();
			String r = st.nextToken();
			lc[i + 1] = l;
			rc[i + 1] = r;
			parent[i + 1] = p;
			map.put(p, i + 1);
		}
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();	
		postorder("A");
	}
}
