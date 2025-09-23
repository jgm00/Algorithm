import java.util.*;
import java.io.*;

public class Main
{
    static int T, N;
    static class Pair{
        int x, y, z;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Integer>[] alst;
    static Pair[] p;
    static int[] vis;
    static int dist(int a, int b){
        int ax = p[a].x;
        int ay = p[a].y;
        int bx = p[b].x;
        int by = p[b].y;
        int dx = Math.abs(ax-bx);
        int dy = Math.abs(ay-by);
        int dst = dx + dy;
        return dst;
    }
    static boolean dfs(int cur){
        if(cur == N+1) return true;
        for(int k : alst[cur]){
            if(vis[k] == 1) continue;
            int ds = dist(k,cur);
            if(ds > 1000) continue;
            vis[k] = 1;
            if(dfs(k)) return true;
        }
        return false;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++){
		    N = Integer.parseInt(br.readLine());
		    alst = new ArrayList[N+2];
		    for(int i=0;i<(N+2);i++){
		        alst[i] = new ArrayList<>();
		        for(int j=0;j<(N+2);j++){
		            if(i==j) continue;
		            alst[i].add(j);
		        }
		    }
		    p = new Pair[N+2];
		    vis = new int[N+2];
		    for(int i=0;i<(N+2); i++){
		        StringTokenizer st = new StringTokenizer(br.readLine());
		        int x = Integer.parseInt(st.nextToken());
		        int y = Integer.parseInt(st.nextToken());
                p[i] = new Pair(x,y);
		    }
		    vis[0] = 1;
    		if(dfs(0)){
    		    System.out.println("happy");
    		}else{
    		    System.out.println("sad");
    		}
		}
	}
}