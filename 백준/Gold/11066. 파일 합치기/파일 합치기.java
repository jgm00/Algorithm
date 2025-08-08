import java.util.*;
import java.io.*;

public class Main
{   
    static int T,K;
    static int[][] DP, sums;
    static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0){
		    K = Integer.parseInt(br.readLine());
		    DP = new int[K+1][K+1];
		    A = new int[K+1];
		    sums = new int[K+1][K+1];
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int i=1;i<=K;i++){
		        A[i] = Integer.parseInt(st.nextToken());
		    }
		    for(int i=1;i<=K;i++){
		        int sum =0;
		        for(int j=i;j<=K;j++){
		            sum += A[j];
		            sums[i][j] = sum;
		        }
		    }
		    for(int len=2;len<=K;len++){
		        for(int i=1;i<=(K+1-len); i++){
		            int j = i + len - 1;
		            DP[i][j] = Integer.MAX_VALUE;
		            for(int k=i; k<=j-1;k++){
		                DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k+1][j] + sums[i][j]);
		            }
		        }
		    }
		    System.out.println(DP[1][K]);
		}
	}
}