import java.util.*;
import java.io.*;

public class Main
{
    static int n,m,r;
    static int[][] dist;
    static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		num = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++){
		    num[i] = Integer.parseInt(st.nextToken());
		}
		dist = new int[n+1][n+1];
		for(int i=1;i<=n;i++){
		    for(int j=1;j<=n;j++){
		        dist[i][j] = Integer.MAX_VALUE;
		        if(i==j){
		            dist[i][j] = 0;
		        }
		    }
		}
		for(int i=0;i<r;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    dist[a][b] = c;
		    dist[b][a] = c;
		}
		for(int k = 1; k<=n ;k++){
		    for(int i=1; i<=n ; i++){
		        for(int j= 1; j<=n; j++){
		            if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
		                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
		            }
		            
		        }
		    }
		}
		int mx = -1;
		for(int i=1;i<=n;i++){
		    int sm = 0;
		    for(int j=1;j<=n;j++){
		        if(dist[i][j] != Integer.MAX_VALUE){
		            if(dist[i][j] <= m){
		                sm += num[j];      
		            }
		        }
		    }
		    mx = Math.max(sm,mx);
		}
		System.out.println(mx);
	}
}