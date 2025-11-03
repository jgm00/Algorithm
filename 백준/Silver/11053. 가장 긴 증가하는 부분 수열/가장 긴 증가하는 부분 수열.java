import java.util.*;
import java.io.*;

public class Main
{
    static int N, ans;
    static int[] num, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N]; cnt = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    num[i] = Integer.parseInt(st.nextToken());
		    int maxValue = 0;
		    for(int j=0;j<i;j++){
		        if(num[i] > num[j] && maxValue < cnt[j]){
		            maxValue = cnt[j];
		        }
		    }
		    cnt[i] = maxValue + 1;
		    ans = Math.max(cnt[i],ans);
		}
		System.out.println(ans);
	}
}