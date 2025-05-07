import java.util.*;
import java.io.*;

public class Main
{
    static int N,K;
    static int[] vis;
    static int[] cnt;
    static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		vis = new int[100001];
		cnt = new int[100001];
		vis[N] = 1;
		cnt[N] = 1;
		q.add(N);
		while(!q.isEmpty()){
		    int cur = q.poll();
            for(int dir =0;dir<3;dir++){
                int ny = 0;
                if(dir == 0){
                    ny = cur -1;
                }else if(dir == 1){
                    ny = cur + 1;
                }else if(dir == 2){
                    ny = cur * 2;
                }
                if(0>ny || ny>=100001) continue;
                if(vis[ny] == 0){
                    vis[ny] = vis[cur] + 1;
                    q.add(ny);
                    cnt[ny] = cnt[cur];
                }else{
                    if(vis[ny] == vis[cur] + 1){
                        cnt[ny] += cnt[cur];
                    }
                }
            }
		}
        if(N!=K){
		    System.out.println(vis[K]-1);
		    System.out.println(cnt[K]);}
        else{
            System.out.println(0);
            System.out.println(1);
}
	}
}