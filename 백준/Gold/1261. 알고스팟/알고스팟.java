import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Pair{
        int x, y, z;
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int N,M;
    static int[][] board, dist;
    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->{
        return o1.x-o2.x;
    });
    static void dj(){
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.x != dist[p.y][p.z]) continue;
            for(int dir = 0; dir < 4; dir++){
                int nx = dx[dir] + p.y;
                int ny = dy[dir] + p.z;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(p.x+board[nx][ny] >= dist[nx][ny]) continue;
                dist[nx][ny] = p.x+board[nx][ny];
                pq.add(new Pair(dist[nx][ny], nx, ny));
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		dist = new int[N][M];
		for(int i=0;i<N;i++){
		    Arrays.fill(dist[i],Integer.MAX_VALUE);
		}
		for(int i=0;i<N;i++){
		    String s = br.readLine();
		    for(int j=0;j<M;j++){
		        board[i][j] = s.charAt(j) - '0';
		    }
		}
		dist[0][0] = 0;
		pq.add(new Pair(0,0,0));
		dj();
		System.out.print(dist[N-1][M-1]);
	}
}