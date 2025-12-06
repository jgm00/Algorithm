import java.io.*;
import java.util.*;

public class Main
{
    static int N,ans;
    static int[][] board;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Pair> even = new ArrayList<>();
    static ArrayList<Pair> odd = new ArrayList<>();
    static int[] vis1, vis2;
    static void dfs(ArrayList<Pair> lst, int cnt, int k){
        if(k==lst.size()){
            ans = Math.max(ans,cnt);
            return;
        }
        Pair p = lst.get(k);
        int x = p.x;
        int y = p.y;
        int a = p.x + p.y;
        int b = p.x - p.y + (N-1);
        if(vis1[a]==0 && vis2[b] == 0){
            vis1[a] = 1;
            vis2[b] = 1;
            dfs(lst,cnt+1,k+1);
            vis1[a] = 0;
            vis2[b] = 0;
        }
        dfs(lst,cnt,k+1);
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        vis1 = new int[N+N+1];
        vis2 = new int[N+N+1];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int k = Integer.parseInt(st.nextToken());
                board[i][j] = k;
                if(k==1){
                    if((i+j)%2 == 0){
                        odd.add(new Pair(i,j));
                    }else{
                        even.add(new Pair(i,j));
                    }
                }
            }
        }
        ans = 0;
        dfs(odd,0,0);
        int ans1 = ans;
        vis1 = new int[N+N+1];
        vis2 = new int[N+N+1];
        ans = 0;dfs(even,0,0);
        int ans2 = ans;
        System.out.println(ans1 + ans2);
	}
}