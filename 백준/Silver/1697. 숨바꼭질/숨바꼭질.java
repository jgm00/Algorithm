import java.io.*;
import java.util.*;

public class Main
{
    static int N,K;
    static int[] vis;
	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<Integer> alist;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        vis = new int[100001];
        alist = new ArrayList<>();
        q.add(N);
        vis[N] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == K){
                System.out.println(vis[cur] - 1);
                break;
            }
            if(cur -1 >= 0 && cur - 1 < 100001){
            int nx = cur - 1;
            if(vis[nx] == 0){
                q.add(nx);
                vis[nx] = vis[cur] + 1;}
            }
            if(cur + 1 >= 0 && cur + 1 < 100001){
            int nx = cur + 1;
            if(vis[nx] == 0){
                q.add(nx);
                vis[nx] = vis[cur] + 1;}
            }
            if(cur * 2 >= 0 && cur * 2 < 100001){
            int nx = cur * 2;
            if(vis[nx] == 0){
                q.add(nx);
                vis[nx] = vis[cur] + 1;}
            }
            
        }
        
	}
}