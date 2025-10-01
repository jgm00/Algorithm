import java.util.*;
import java.io.*;

public class Main
{
    static int N, L;
    static int answer = 0;
    static int[][] board, tmp;
    static boolean chk(int i, int[][] board){
        int st = board[i][0];
        int cnt = 1;
        for(int j=1;j<N;j++){
            int cur = board[i][j];
            if(st == cur){
                cnt += 1;
            }else if(st > cur){
                if(st > (cur + 1)) return false;
                for(int k = j; k< (j+L); k++){
                    if(k >= N) return false;
                    if(cur != board[i][k]){
                        return false;
                    }
                }
                j=Math.min(N,(j+L)-1);
                cnt = 0;
            }else{
                if((st+1) < cur) return false;
                if(cnt < L) return false;
                cnt = 1;
            }
            st = cur;
        }
        return true;
    }
    static void turnR(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                 tmp[i][j] = board[N-j-1][i];
            }
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        tmp = new int[N][N];
        turnR();
        for(int i=0;i<N;i++){
            if(chk(i,board)){
                answer += 1;
            }
        }
        for(int i=0;i<N;i++){
            if(chk(i,tmp)){
                answer += 1;
            }
        }
        System.out.println(answer);
	}
}