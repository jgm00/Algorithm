import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> pq1 = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int k = Integer.parseInt(st.nextToken());
            pq.add(k);
        }
        int sm = 0;
        while(!pq.isEmpty()){
            sm += pq.poll();
            pq1.add(sm);
        }
        int ans = 0;
        while(!pq1.isEmpty()){
            ans += pq1.poll();
        }
        System.out.println(ans);
	}
}