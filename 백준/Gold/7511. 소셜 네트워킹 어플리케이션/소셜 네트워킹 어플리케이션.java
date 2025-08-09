import java.util.*;
import java.io.*;

public class Main
{
    static int T,n,k,a,b,m,u,v;
    static int[] p;
    static int[] r;
    static int find(int x){
        if(p[x] == -1) return x;
        return p[x] = find(p[x]);
    }
    static void merge(int a, int b){
        a = find(a); b = find(b);
        if(a==b) return;
        if(r[a] < r[b]){
            p[a] = b;
        }else{
            p[b] = a;
            if(r[a] == r[b]){
                r[a]+=1;
            }
        }
        
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++){
		    System.out.println("Scenario " + tc + ":");
		    n = Integer.parseInt(br.readLine());
		    r = new int[n+1];
		    p = new int[n+1];
		    Arrays.fill(p,-1);
		    k = Integer.parseInt(br.readLine());
		    for(int i=0;i<k;i++){
		        StringTokenizer st = new StringTokenizer(br.readLine());
		        a = Integer.parseInt(st.nextToken());
		        b = Integer.parseInt(st.nextToken());
		        merge(a,b);
		    }
		    m = Integer.parseInt(br.readLine());
		    for(int i=0;i<m;i++){
		        StringTokenizer st = new StringTokenizer(br.readLine());
		        u = Integer.parseInt(st.nextToken());
		        v = Integer.parseInt(st.nextToken());
		        if(find(u)==find(v)){
		            System.out.println("1");
		        }else{
		            System.out.println("0");
		        }
		    }
		    System.out.println();
		}
	}
}