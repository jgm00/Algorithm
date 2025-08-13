import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static long[][] dist;
    static StringTokenizer st;
    static long INF = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		dist = new long[n+1][n+1];
		for(int i=0;i<=n;i++){
		    Arrays.fill(dist[i], INF);
		}
		for(int i=0;i<m;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    dist[a][b] = Math.min(dist[a][b], c);
		}
		for(int i=1;i<=n;i++){
		    for(int j=1;j<=n;j++){
		        if(i==j) dist[i][j] = 0;
		    }
		}
		for(int k = 1; k<=n;k++){
		    for(int i=1;i<=n;i++){
		        for(int j=1;j<=n;j++){
		            if(dist[i][k] == INF || dist[k][j] == INF) continue;
		            dist[i][j] = Math.min(dist[i][j], (dist[i][k] + dist[k][j]));
		        }
		    }
		}
		for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (dist[i][j] == Long.MAX_VALUE) {
                    System.out.print("0 ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
	}
}