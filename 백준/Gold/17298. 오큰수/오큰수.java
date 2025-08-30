import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static Stack<Integer> q = new Stack<>();
    static int[] num, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		ans = new int[N];
        StringBuilder sb = new StringBuilder();
		Arrays.fill(ans, -1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++){
		    num[i] = Integer.parseInt(st.nextToken());
		}
		q.add(0);
		for(int i=1;i<N;i++){
		    while(q.isEmpty() == false && num[q.peek()] < num[i]){
		        ans[q.peek()] = num[i];
		        q.pop();
		    }
		    q.add(i);
		}
		for(int i=0;i<N;i++){
		    sb.append(ans[i] + " ");
		}
        System.out.println(sb.toString());
	}
}