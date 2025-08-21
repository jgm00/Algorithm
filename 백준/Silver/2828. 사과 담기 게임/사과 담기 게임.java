import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,J;
    static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		J = Integer.parseInt(br.readLine());
		int l = 0; int r = l + M;
		for(int i=0;i<J;i++){
		    int k = Integer.parseInt(br.readLine());
		    if(r < k){
		        ans += (k-r);
		        r = k; l = r - M;
		    }else if(l >= k){
		        ans += (l-(k-1));
		        l = (k-1); r = l + M;
		    }
		}
		System.out.println(ans);
	}
}