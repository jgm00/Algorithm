import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static int[] p,r,num;
    static int[][] board;
    static int find(int x){
        if(p[x] == -1) return x;
        return p[x] = find(p[x]);
    }
    static void merge(int a, int b){
        a = find(a); b=find(b);
        if(a == b) return;
        if(r[a] < r[b]){
            p[a] = b;
        }else{
            p[b] = a;
            if(r[a]==r[b]){
                r[a] += 1;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		num = new int[M+1];
		p = new int[N+1];
		r = new int[N+1];
		Arrays.fill(p,-1);
		board = new int[N+1][N+1];
	    for(int i=1;i<=N;i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j=1;j<=N;j++){
		        board[i][j] = Integer.parseInt(st.nextToken());
		    }
		}

		for(int i=1;i<=N;i++){
		    for(int j=1;j<=N;j++){
		        if(board[i][j] == 1){
		            merge(i,j);
		        }
		    }
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M;i++){
		    num[i] = Integer.parseInt(st.nextToken());
		}
		int flag = 0;
		for(int i = 1; i<M;i++){
		    if(find(num[i-1]) != find(num[i])){
		        flag = 1;
		    }
		}
		if(flag == 1){
		    System.out.println("NO");
		}else{
		    System.out.println("YES");
		}
	}
}