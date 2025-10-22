import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Pair> alst = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    alst.add(new Pair(a,b));
		}
		alst.sort((o1,o2)->{
		    if(o1.x == o2.x){
		        return o2.y - o1.y;
		    }
		    return o1.x - o2.x;
		});
		for(Pair p : alst){
		   pq.add(p.y);
		   if(pq.size() > p.x){
		       pq.poll();
		   }
		}
		int ans = 0;
		while(!pq.isEmpty()){
		    ans += pq.poll();
		}
		System.out.println(ans);
	}
}