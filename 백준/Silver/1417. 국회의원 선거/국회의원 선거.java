import java.util.*;
import java.io.*;

public class Main
{
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int idx = Integer.parseInt(br.readLine());
        for(int i=1;i<N;i++){
            int k = Integer.parseInt(br.readLine());
            pq.add(k);
        }
        int cnt = 0;
        while(!pq.isEmpty() && pq.peek() >= idx){
            int cur = pq.poll();
            cur--;
            idx++;
            cnt++;
            pq.add(cur);
        }
        System.out.println(cnt);
	}
}