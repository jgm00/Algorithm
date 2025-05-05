import java.util.*;
import java.io.*;

public class Main
{   
    static int N;
    static int[] SCV;
    static class Trip{
        int x, y,z;
        Trip(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[][] damage = {{9,3,1},{9,1,3},{1,3,9},{1,9,3},{3,9,1},{3,1,9}};
    static Queue<Trip> q = new LinkedList<>();
    static int ans;
    static int[][][] vis;
    static void bfs(){
        while(!q.isEmpty()){
            if(vis[0][0][0] == 1) return;
            Trip cur = q.poll();
            for(int i=0;i<6;i++){
                int a = Math.max(0, cur.x - damage[i][0]);
                int b = Math.max(0, cur.y - damage[i][1]);
                int c = Math.max(0, cur.z - damage[i][2]);
                if(vis[a][b][c] != 0) continue;
                vis[a][b][c] = vis[cur.x][cur.y][cur.z] + 1;
                q.add(new Trip(a,b,c));
            }
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		SCV = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    SCV[i] = Integer.parseInt(st.nextToken());
		}
		vis = new int[61][61][61];
		vis[SCV[0]][SCV[1]][SCV[2]] = 1;
        q.add(new Trip(SCV[0],SCV[1],SCV[2]));  
        bfs();
        System.out.println(vis[0][0][0] - 1);
	}
}