import java.util.*;
import java.io.*;

public class Main
{
    static int N,K,ans;
    static int[] num;
    static List<Integer> hset = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++){
		    int k = Integer.parseInt(st.nextToken());
		    num[i] = k;
		}
		for(int i=0;i<K;i++){
		    int cur = num[i];
		    if(hset.size() < N){
                if (!hset.contains(cur)) hset.add(cur);
		    }else if(hset.contains(cur)){
		        continue;
		    }else{
		        Integer lastitem = -1;
		        Integer tar = -1;
		        for(int k : hset){
		            Integer nxt = Integer.MAX_VALUE;
		            for(int j=i+1;j<K;j++){
		                if(num[j] == k){
		                    nxt = j;
		                    break;
		                }
		            }
		            if(lastitem < nxt){
		                lastitem = nxt;
		                tar = k;
		            }
		        }
		        hset.remove(tar);
		        hset.add(cur);
		        ans += 1;
		    }
		}
		System.out.println(ans);
	}
}