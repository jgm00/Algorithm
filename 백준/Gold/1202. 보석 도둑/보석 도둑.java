import java.util.*;
import java.io.*;

public class Main
{
    static int N,K,M,V,C;
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Pair[] p;
    static int[] Cs;
    static long ans;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Cs = new int[K];
        p = new Pair[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            p[i] = new Pair(M,V);
        }
        for(int i=0;i<K;i++){
            Cs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Cs);
        Arrays.sort(p,(o1,o2)->{
            return o1.x - o2.x;
        });
        int j = 0;
        for(int i=0;i<K;i++){
            while(j<N && p[j].x <= Cs[i]){
                pq.add(p[j++].y);
            }
            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }
        System.out.println(ans);
	}
}