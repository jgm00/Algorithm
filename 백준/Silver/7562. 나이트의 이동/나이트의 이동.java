import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int T;
    static int I,x1,x2,y1,y2;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,1,-1,2,-2,2,-2};
    static int[] dy = {-2,-2,2,2,-1,-1,1,1};
    static Queue<Pair> q;
    static void bfs(){
        while(!q.isEmpty()){
                Pair p = q.poll();
                if(p.x == x2 && p.y == y2){
                    System.out.println(vis[x2][y2] -1);
                    return;
                }
                for(int dir =0;dir<8;dir++){
                    int nx = dx[dir] + p.x;
                    int ny = dy[dir] + p.y;
                    if(nx < 0 || ny < 0 || nx >=I || ny >=I) continue;
                    if(vis[nx][ny] != 0) continue;
                    q.add(new Pair(nx,ny));
                    vis[nx][ny] = vis[p.x][p.y] + 1;
                }
                
            }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            I = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            board = new int[I][I];
            vis = new int[I][I];
            q = new LinkedList<>();
            q.add(new Pair(x1,y1));
            vis[x1][y1] = 1;
            bfs();
        }
        
    }
}
