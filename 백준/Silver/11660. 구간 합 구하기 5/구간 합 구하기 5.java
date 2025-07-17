import java.io.*;
import java.util.*;

public class Main
{   
    static int[][] board;
    static int[][] psum;
	static int N,M;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        psum = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        psum[0][0] = board[0][0];
        for(int i=0;i<N;i++){
            psum[i][0] = board[i][0];
            for(int j =1;j<N;j++){
                psum[i][j] = psum[i][j-1] + board[i][j];
            }
        }
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            sum =0;
            for(int j=x1;j<=x2;j++){
                if(y1 == 0){
                    sum += psum[j][y2];
                }else{
                    sum += psum[j][y2] - psum[j][y1-1];
                }    
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
	}
}