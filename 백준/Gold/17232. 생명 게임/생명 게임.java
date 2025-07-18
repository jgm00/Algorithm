import java.io.*;
import java.util.*;

public class Main
{   
    static int N,M,T;
    static int K,a,b;
    static char[][] board;
    static int[][] psum;
    static int[][] makePsum(){
        int[][] newsum = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            for(int j =1;j<M+1;j++){
                int a = 0;
                if(board[i-1][j-1] == '*'){
                    a = 1;
                }
                newsum[i][j] = newsum[i-1][j] + newsum[i][j-1] - newsum[i-1][j-1] + a;
            }
        }
        return newsum;
    }
    static int getLife(int i, int j){
        int r1 = Math.max(i-K,1);
        int c1 = Math.max(j-K,1);
        int r2 = Math.min(i+K,N);
        int c2 = Math.min(j+K,M);
        return psum[r2][c2] - psum[r1-1][c2] - psum[r2][c1-1] + psum[r1-1][c1-1];
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        psum = new int[N+1][M+1];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j] = s.charAt(j);
            }
        }
        while(T-->0){
            psum = makePsum();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int l = getLife(i+1,j+1);
                    if(board[i][j] == '*'){
                        l--;
                        if(l >= a && l <= b){
                            board[i][j] =  '*';
                        }else{
                            board[i][j] =  '.'; 
                        }
                    }else if(board[i][j] ==  '.' && a < l && l <= b){
                        board[i][j] = '*';
                    }
                }   
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(board[i][j]);
              }
          System.out.println();
        }
	}
}