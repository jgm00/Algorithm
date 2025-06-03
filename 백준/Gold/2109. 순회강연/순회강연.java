import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static class Pair{
        int p;
        int d;
        
        Pair(int p, int d){
            this.p = p;
            this.d = d;
        }
    }
    static Pair[] ps;
    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->{
        return o1.p - o2.p;
    });
    static int ret = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ps = new Pair[N];
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int p = Integer.parseInt(st.nextToken());
		    int d = Integer.parseInt(st.nextToken());
		    Pair pr = new Pair(p,d);
            ps[i] = pr;
		}
		Arrays.sort(ps,(o1,o2)->{
		    return o1.d - o2.d;
		});
		for(int i = 0;i<N;i++){
		    pq.add(ps[i]);
		    if(pq.size() > ps[i].d){
		        Pair pp = pq.poll();
		    }
		}
		while(!pq.isEmpty()){
		    ret += pq.poll().p;
		}
		System.out.println(ret);
	}
}