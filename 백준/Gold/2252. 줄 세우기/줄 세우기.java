import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static ArrayList<Integer>[] adj;
    static int[] indegree;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
        return o1 - o2;
    });
    static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		indegree = new int[N+1];
		for(int i=1;i<=N;i++){
		    adj[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int A = Integer.parseInt(st.nextToken());
		    int B = Integer.parseInt(st.nextToken());
		    adj[A].add(B);
		    indegree[B] +=1;
		}
		for(int i=1;i<=N;i++){
		    if(indegree[i] == 0){
		        q.add(i);
		    }
		}
	while(!q.isEmpty()){
	        int k = q.poll();
	        System.out.print(k + " ");
	        pq.add(k);
	        for(int nxt : adj[k]){
	            indegree[nxt]-=1;
    	        if(indegree[nxt] == 0){
    	            q.add(nxt);
    	        }
	        }
	    }
	}
}