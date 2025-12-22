import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static class Pair{
        int x,y,z;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static ArrayList<Pair>[] adj;
    static int[] dist,pre;
    static ArrayList<Integer> answer = new ArrayList<>();
    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->{return o1.x-o2.x;});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		dist = new int[N+1];
		pre = new int[N+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		for(int i=1;i<=N;i++){
		    adj[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    adj[u].add(new Pair(v,w));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
        dist[a] = 0;
        pq.add(new Pair(0,a));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(dist[p.y] != p.x) continue;
            for(Pair nxt : adj[p.y]){
                if(dist[nxt.x] > dist[p.y] + nxt.y){
                    dist[nxt.x] = dist[p.y] + nxt.y;
                    pq.add(new Pair(dist[nxt.x],nxt.x));
                    pre[nxt.x] = p.y;
                }
            }
        }
        int cnt = 0;
        int end = b;
        while(end != 0){
            answer.add(end);  
            end = pre[end];
            cnt += 1;
        }
        System.out.println(dist[b]);
        System.out.println(cnt);
        for(int i=cnt-1;i>=0;i--){
            System.out.print(answer.get(i) + " ");
        }
	}
}