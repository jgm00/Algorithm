import java.io.*;
import java.util.*;

public class Main
{
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N,M;
    static StringTokenizer st;
    static PriorityQueue<Pair> pq = new PriorityQueue<Pair>((o1,o2)->{
        return o1.y - o2.y;
    });
    static int[] dist;
    static int[] pre;
    static ArrayList<Pair>[] graph;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        pre = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            
            graph[s1].add(new Pair(v1,d1));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dist[start] = 0;
        pq.add(new Pair(start,0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(dist[p.x] != p.y) continue;
            for(Pair nxt : graph[p.x]){
                int nd = dist[p.x] + nxt.y;
                if(dist[nxt.x] > nd ){
                    pq.add(new Pair(nxt.x, nd));
                    dist[nxt.x] = nd;
                    pre[nxt.x] = p.x;
                }
            }
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        System.out.println(dist[end]);
        int ed = end;
        while(true){
            temp.add(ed);
            ed = pre[ed];
            if(ed == start){
                break;
            }
        }
        temp.add(start);
        System.out.println(temp.size());
        for(int i=temp.size()-1;i>=0;i--){
            System.out.print(temp.get(i) + " ");
        }
	}
}