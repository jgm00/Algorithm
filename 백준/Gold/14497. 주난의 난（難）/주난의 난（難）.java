import java.io.*;
import java.util.*;


public class Main
{
    static int N,M,x1,x2,y1,y2;
    static char[][] board;
    static int[][] vis;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Integer> q = new LinkedList<>();
    static Queue<Integer> stq = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken()) - 1;
		y1 = Integer.parseInt(st.nextToken()) - 1;
		x2 = Integer.parseInt(st.nextToken())- 1;
		y2 = Integer.parseInt(st.nextToken()) - 1;
		board = new char[N][M]; vis = new int[N][M];
		for(int i=0;i<N;i++){
		    String s = br.readLine();
		    for(int j=0;j<M;j++){
		        board[i][j] = s.charAt(j);
		    }
		}
		int cal = 1;
		q.add(x1); q.add(y1);
		vis[x1][y1] = cal;
		while(true){
		    if(board[x2][y2] == '0') break;
		while(!q.isEmpty()){
		    int curx = q.poll();
		    int cury = q.poll();
		    for(int dir =0; dir<4; dir++){
		        int nx = dx[dir] + curx;
		        int ny = dy[dir] + cury;
		        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
		        if(vis[nx][ny] != 0) continue;
		        if(board[nx][ny] == '0'){
		            q.add(nx); q.add(ny);
		            
		        }else{
		            board[nx][ny] = '0';
		            stq.add(nx); stq.add(ny);
		            }vis[nx][ny] = cal;
		        }
		    }
		    cal+=1;
		    while(!stq.isEmpty()){
		        q.add(stq.poll());
		    }
		}
		System.out.println(vis[x2][y2]);
	}
}