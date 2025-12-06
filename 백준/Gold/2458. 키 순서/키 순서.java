import java.io.*;
import java.util.*;

public class Main
{
    static int N,M,ans;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N+1][N+1];
		for(int i=0;i<N+1;i++){
		    Arrays.fill(dist[i],INF);
		    dist[i][i] = 0;
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    dist[a][b] = 1;
		}
		for(int k=1;k<=N;k++){
		    for(int i=1;i<=N;i++){
		        for(int j=1;j<=N;j++){
		            if(dist[i][k] != INF && dist[k][j] != INF){
		                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
		            }
		        }
		    }
		}
		for(int i=1;i<=N;i++){
		    int flag = 0;
		    for(int j=1;j<=N;j++){
		        if(dist[i][j] == INF && dist[j][i] == INF){
                    flag = 1;
                    break;
		        }
		    }
		    if(flag == 0){
		        ans+=1;
		    }
		}
		System.out.println(ans);
	}
}