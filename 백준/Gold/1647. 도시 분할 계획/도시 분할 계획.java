import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static class Pair{
        int x,y,z;
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static List<Pair> adj = new ArrayList<>();
    static int[] p;
    static int find(int k){
        if(p[k] < 0) return k;
        return p[k] = find(p[k]);
    }
    
    static boolean union(int a, int b){
        a = find(a); b = find(b);
        if(a == b) return false;
        if(p[a] > p[b]){
            int tmp = a; a = b; b = tmp;
        } 
        p[a] += p[b];
        p[b] = a;
        return true;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	    p = new int[N+1];
	    Arrays.fill(p,-1);
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
            adj.add(new Pair(c,a,b));
		}
		Collections.sort(adj,(o1,o2)->{
		    return o1.x - o2.x;
		});
		long answer = 0;
		long sm = 0;
		int cnt = 0;
		for(Pair p : adj){
		    if(!union(p.y,p.z)) continue;
		    sm += p.x;
		    answer = Math.max(p.x,answer);
		    cnt+=1;
		    if(cnt == N-1) break;
		}
		System.out.println(sm - answer);
	}
}