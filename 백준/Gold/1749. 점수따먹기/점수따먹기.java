import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static long mx =Long.MIN_VALUE;
    static long[][] psum;
    static int[][] arr;
    static long cal(int x1, int y1, int x2, int y2){
        return psum[x2][y2] - psum[x2][y1-1] - psum[x1-1][y2] + psum[x1-1][y1-1];
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        psum = new long[N+1][M+1];
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                psum[i][j] = psum[i][j-1] + psum[i-1][j] - psum[i-1][j-1] + arr[i-1][j-1];
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                for(int k = i; k<=N;k++){
                    for(int t = j; t <= M; t++){
                        long tmp = cal(i,j,k,t);
                        mx = Math.max(mx,tmp);
                    }
                }
            }
        }
        System.out.println(mx);
	}
}