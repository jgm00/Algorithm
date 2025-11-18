import java.util.*;
import java.io.*;

public class Main {
	static int N,S,W;
	static class Pair{
		int x,y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int brkidx = 0;
	static int ans = 0;
	static Pair[] egg;
	static int[] brk, vis;
	static void dfs(int k) {
		if(k==N) {
			int cnt = 0;
			for(int i=0;i<N;i++) {
				if(egg[i].x <= 0) cnt +=1;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		if(egg[k].x <= 0) {
			dfs(k+1);
			return;
		}
		boolean hit = false;
		for(int i = 0;i<N;i++) {
			if(i == k) continue;
			if(egg[i].x <= 0) continue;
			hit = true;
			int curD = egg[k].x;
			int tarD = egg[i].x;
			egg[k].x -= egg[i].y;
			egg[i].x -= egg[k].y;
			dfs(k+1);
			egg[k].x = curD;
			egg[i].x = tarD;
		}
		if(!hit) {
			dfs(k+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		egg= new Pair[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			egg[i] = new Pair(S,W);
		}
		brk = new int[N];
		dfs(0);
		System.out.println(ans);
	}
}
