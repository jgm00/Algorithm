import java.util.*;
import java.io.*;

public class Main
{
    static int N, ans, mx;
    static int[] num, cnt, prev;
    static ArrayList<Integer> anss = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N]; cnt = new int[N]; prev = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Arrays.fill(prev,-1);
		for(int i=0;i<N;i++){
		    num[i] = Integer.parseInt(st.nextToken());
		    int maxValue = 0;
		    for(int j=0;j<i;j++){
		        if(num[i] > num[j] && maxValue < cnt[j]){
		            maxValue = cnt[j];
		            prev[i] = j;
		        }
		    }
		    cnt[i] = maxValue + 1;
            ans = Math.max(ans, cnt[i]);
            if(ans == cnt[i]){
                mx = i;
            }
		}
        while(mx != -1){
            anss.add(num[mx]);
            mx = prev[mx];
        }
        System.out.println(ans);
        for(int i=anss.size()-1; i>=0; i--){
            System.out.print(anss.get(i) + " ");
        }
	}
}