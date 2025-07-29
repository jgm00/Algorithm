import java.util.*;
import java.io.*;

public class Main {
    static int n,m,a1,a2;
    static ArrayList<Integer>[] adj;
    static int[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            adj[i] = new ArrayList<>();
        }
        
        m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y); adj[y].add(x);
        }
        vis= new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(a1);
        vis[a1] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int k : adj[cur]){
                if(vis[k]!= 0) continue;
                q.add(k);
                vis[k] = vis[cur] + 1;
            }
        }
        System.out.println(vis[a2] - 1);
    }
}
