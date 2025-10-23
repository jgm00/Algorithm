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
    static Pair[] num;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new Pair[N];
		for(int i =0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    num[i] = new Pair(a,b);
		}
		Arrays.sort(num, (o1,o2) -> {
		    if(o1.x == o2.x){
		        return o1.y - o2.y; 
		    }
		    return o1.x - o2.x;
		});
		long start = num[0].x + num[0].y;
		pq.add(start);
		for(int i = 1; i<N;i++){
		    long k = pq.poll();
		    if(k <= num[i].x){
		        pq.add((long) num[i].y+num[i].x);
		    }else{
		        pq.add((long) num[i].y+k);
		    }
		}
		System.out.println(pq.poll());
	}
}