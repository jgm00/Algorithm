import java.util.*;
import java.io.*;

public class Main
{
    static int T,N;
    static class Pair{
        int x, y,z;
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static PriorityQueue<Pair> pq;
    static int[][] board;
    static int[][] dist;
    static void dijkstra(int x, int y){
        dist = new int[N][N];
        pq = new PriorityQueue<>((o1,o2)->o1.z-o2.z);
        for(int i=0;i<N;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[x][y] = board[x][y];
        pq.add(new Pair(x,y,board[x][y]));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(dist[p.x][p.y] != p.z) continue;
            for(int dir =0;dir<4;dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx>=N || ny>=N) continue;
                if((dist[p.x][p.y] + board[nx][ny]) >= dist[nx][ny]) continue;
                dist[nx][ny] = dist[p.x][p.y] + board[nx][ny];
                pq.add(new Pair(nx,ny,dist[nx][ny]));
            }
        }
        
    }
	public static void main(String[] args) throws IOException {
	    int tc =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            tc++;
            board = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra(0,0);
            System.out.println("Problem " + tc + ": " + dist[N-1][N-1]);
        }
	}
}