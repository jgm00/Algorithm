import java.io.*;
import java.util.*;

public class Main
{
    static int M,N,K,x1,y1,x2,y2;
    static int[][] board,vis;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int k = 0;
    static Queue<Pair> q = new LinkedList<>();
    static ArrayList<Integer> alist = new ArrayList<>();
    static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();
            k+=1;
            for(int dir =0; dir<4; dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(board[nx][ny] == 1 || vis[nx][ny] != 0) continue;
                vis[nx][ny] = 1;
                q.add(new Pair(nx,ny));
            }
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[M][N];
        vis = new int[M][N];
        for(int tc=0;tc<K;tc++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for(int i=(M-y2); i<=(M-y1-1); i++){
        	    for(int j=x1; j<=(x2-1); j++){
        	        board[i][j] = 1;
        	    }
        	}
        }
        StringBuilder sb = new StringBuilder();
        	int cnt = 0;
        	for(int i=0;i<M;i++){
        	    for(int j=0;j<N;j++){
        	        if(board[i][j] == 0 && vis[i][j] == 0){
        	            q.add(new Pair(i,j));
        	            k = 0;
        	            vis[i][j] = 1;
        	            cnt+=1;
        	            bfs();
        	            alist.add(k);
        	        }
        	    }
        	}
        Collections.sort(alist);
        System.out.println(cnt);
        for(int i=0;i<cnt;i++){
           System.out.print(alist.get(i) + " "); 
        }
        
	}
}