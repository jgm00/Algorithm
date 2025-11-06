import java.util.*;
import java.io.*;

public class Main
{
    static int N,K, mx;
    static String[] strs;
    static int[] vis;
    static void cal(){
        int cnt = 0; int flag = 0;
        for(int i =0;i<N;i++){
            String s = strs[i];
            flag = 0;
            for(int j=0;j<s.length();j++){
                char c = s.charAt(j);
                if(vis[c-'a'] == 0){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                cnt += 1;
            }
            
        }
        mx = Math.max(mx,cnt);
    }
    static void dfs(int st, int k){
        if(k==K-5){
            cal();
            return;
        }
        for(int i=st;i<26;i++){
            if(vis[i] == 0){
                vis[i] = 1;
                dfs(i+1,k+1);
                vis[i] = 0;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		vis = new int[26];
		strs = new String[N];
		K = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++){
		    strs[i] = br.readLine();
		}
		vis['a'-'a'] = 1; vis['n'-'a'] = 1; vis['t'-'a'] = 1; vis['i'-'a'] = 1; vis['c'-'a'] = 1;
		if(K<5){
		    System.out.println(0);
		    return;
		}else if(K==26){
            System.out.println(N);
            return;
        }
		dfs(0,0);
		System.out.println(mx);
	}
}