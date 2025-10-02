import java.util.*;
import java.io.*;

public class Main
{
    static int N,T,S;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Pair[] ps;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ps = new Pair[N];
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    T = Integer.parseInt(st.nextToken());
		    S = Integer.parseInt(st.nextToken());
		    Pair p = new Pair(T,S);
		    ps[i] = p;
		}
        Arrays.sort(ps,(o1,o2)->{
            if(o1.x == o2.x){
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });
        int ans = 0;
        pq.add(ps[0].y);
        for(int i=1;i<N;i++){
            if(pq.peek() <= ps[i].x){
                pq.poll();
            }else{
                ans +=1;
            }
            pq.add(ps[i].y);
        }
        System.out.println(ans + 1);
	}
}