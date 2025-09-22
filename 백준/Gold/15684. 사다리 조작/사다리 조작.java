import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,H;
    static int[][] board, vis;
    static boolean chk(){
        for(int i=1; i<=N;i++){
            int h = 1;
            int y = i;
            while(h <= H){
                if(board[h][y] == 1){
                    y+=1;
                }else if(board[h][y-1] == 1){
                    y-=1;
                }
                h+=1;
            }
            if(y!=i){
                return false;
            }
        }
        return true;
    }
    static int mn = Integer.MAX_VALUE;
    static void dfs(int k){
        if(1 == k || 2 == k){
            if(chk() == true){
                mn = Math.min(mn,k);
            };
        }
        if(3 == k){
            if(chk() == true){
                mn = Math.min(mn,k);
            };
            return;
        }
        for(int i=1;i<=H;i++){
            for(int j=1;j<N;j++){
                if(board[i][j] == 1) continue;
                board[i][j] = 1;
                dfs(k+1);
                board[i][j] = 0;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		vis = new int[H+1][N+1];
		board = new int[H+1][N+1];
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    board[a][b] = 1;
		}
		if(chk()== true){
		    System.out.println(0);
		}else{
		    dfs(0);
            if(mn == Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(mn);
            }
            
		}
		
		
	}
}