import java.util.*;
import java.io.*;

public class Main
{   
    static int N;
    static int[] parent, lc, rc, he;
    static int[][] ans;
    static int mxh;
    static int anss = -1;
    static int ansn = -1;
    static void dfs(int cur, int d){
        if(cur == -1) return;
        he[cur] = d;
        mxh = Math.max(mxh,d);
        dfs(lc[cur], d+1);
        dfs(rc[cur], d+1);
    }
    static int idx = 1;
    static void inorder(int cur){
        if(lc[cur] != -1) inorder(lc[cur]);
        if(ans[he[cur]][0] == 0){
            ans[he[cur]][0] = idx;   
        }
        ans[he[cur]][1] = Math.max(ans[he[cur]][1], idx);
        idx++;
        if(rc[cur] != -1) inorder(rc[cur]);
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		he = new int[N+1];
		parent = new int[N+1];
		lc = new int[N+1];
		rc = new int[N+1];
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int p = Integer.parseInt(st.nextToken());
		    int l = Integer.parseInt(st.nextToken());
		    int r = Integer.parseInt(st.nextToken());
            lc[p] = l; rc[p] = r;
            if(l != -1) parent[l] = p;
            if(r != -1) parent[r] = p;
		}
		int root = -1;
		for(int i=1; i<=N; i++){
		    if(parent[i] == 0){
		        root = i;
		    }
		}
		dfs(root,1);
		ans = new int[mxh+1][2];
		inorder(root);
		for(int i=1;i<=mxh;i++){
		    int dff = (ans[i][1] - ans[i][0]);
		    if(dff > anss){
		        ansn = i;
		        anss = dff;
		    }
		}
		System.out.println(ansn + " " + (anss+1));
	}
}