import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,K;
    static int[] p,r, cost;
    static int find(int x){
        if(x == p[x]){
            return x;
        }
        return p[x] = find(p[x]);
    }
    
    static boolean merge(int a, int b){
        a = find(a); b = find(b);
        if(a == b){
            return false;
        }
        if(cost[a] > cost[b]){
            p[a] = b;
        }else{
            p[b] = a;
        }
        return true;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cost = new int[N+1];
		p = new int[N+1];
		long costsm = 0;
		int ans = 0;
		ans = K;
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
		    cost[i] = Integer.parseInt(st.nextToken());
		    p[i] = i;
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    merge(u,v);
		}
		for(int i=1;i<=N;i++){
		    if(p[i] == i){
		        ans -= cost[i];
		        costsm += cost[i];
		    }
		}
		if(ans < 0){
		    System.out.println("Oh no");
		}else{
		    System.out.println(costsm);
		}
		
	}
}