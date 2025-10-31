import java.util.*;
import java.io.*;

public class Main
{
    static int N, sm1, sm2;
    static int answer = Integer.MAX_VALUE;
    static int[] arr;
    static int[][] board;
    static void cal(int N){
        for(int i=0;i<(1<<N); i++){
            arr = new int[N];
            for(int j=0;j<N;j++){
                if((i&(1<<j)) != 0){
                    arr[j] = 1;
                }
            }
            sm1 = 0; sm2 = 0;
            for(int k=0;k<N;k++){
                for(int kk = k+1; kk<N;kk++){
                    if(arr[k]==arr[kk]){
                        if(arr[k]==0){
                            sm1 += board[k][kk];
                            sm1 += board[kk][k];
                        }else{
                            sm2 += board[k][kk];
                            sm2 += board[kk][k];
                        }
                    }
                }
            }
            answer = Math.min(Math.abs(sm1 - sm2),answer);
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        board[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		cal(N);
		System.out.println(answer);
	}
}