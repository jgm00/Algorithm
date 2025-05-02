import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static PriorityQueue<Pair> pq;
    
    static int[] dist;
    static ArrayList<Pair>[] alist;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine());
	    alist = new ArrayList[N+1];
	    dist = new int[N+1];
	    for(int i=0;i<N+1;i++){
	        alist[i] = new ArrayList<Pair>();
	        dist[i] = Integer.MAX_VALUE;
	    }
	    pq = new PriorityQueue<Pair>((o1,o2)->{
	        return o1.y - o2.y;
	    });
	    for(int i=0;i<M;i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int v1 = Integer.parseInt(st.nextToken());
	        int s1 = Integer.parseInt(st.nextToken());
	        int d1 = Integer.parseInt(st.nextToken());
	        
	        alist[v1].add(new Pair(s1,d1));

	    }
	    StringTokenizer st = new StringTokenizer(br.readLine());
        int mys = Integer.parseInt(st.nextToken());
        int myv = Integer.parseInt(st.nextToken());
        
        dist[mys] = 0;
        pq.add(new Pair(mys,0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.y != dist[p.x]) continue;
            for(Pair nxt : alist[p.x]){
                int dn = dist[p.x] + nxt.y;
                if(dn < dist[nxt.x]) {
                    pq.add(new Pair(nxt.x, dn));
                    dist[nxt.x] = dn;
                }
            }
        }
        System.out.println(dist[myv]);
	}
}