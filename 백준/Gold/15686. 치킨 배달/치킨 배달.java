import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static class Pair{
		int x,y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int sz;
	static int[][] board;
	static ArrayList<Pair> home = new ArrayList<>();
	static ArrayList<Pair> chicken = new ArrayList<>();
	static int[] arr;
	static int[] vis;
	static int mn = Integer.MAX_VALUE;
	static int ans = Integer.MAX_VALUE;
	static void cal(int[] arr) {
		int sm = 0;
		for(int i=0;i<home.size();i++) {
			Pair h = home.get(i);
			mn = Integer.MAX_VALUE;
			for(int j=0;j<arr.length;j++) {
				Pair p = chicken.get(arr[j]);
				int dffx = Math.abs(h.x-p.x);
				int dffy = Math.abs(h.y-p.y);
				mn = Math.min(mn, (dffx+dffy));
			}
			sm += mn;
		}
		ans = Math.min(ans, sm);
	}
	static void dfs(int k) {
		if(k==M) {
			cal(arr);
			return;
		}
		int start = 0;
		if(k!=0) {
			start = arr[k-1];
		}
		for(int i=start;i<sz;i++) {
			if(vis[i] == 0) {
				arr[k] = i;
				vis[i] = 1;
				dfs(k+1);
				vis[i] = 0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int k = Integer.parseInt(st.nextToken());
				if(k == 1) {
					home.add(new Pair(i,j));
				}else if(k==2) {
					chicken.add(new Pair(i,j));
				}
			}
		}
		sz = chicken.size();
		arr = new int[M];
		vis = new int[sz+1];
		dfs(0);
		System.out.println(ans);
	}
}
