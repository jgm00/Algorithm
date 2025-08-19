import java.io.*;
import java.util.*;

public class Main
{
    static int L,C;
    static String[] arr;
    static int[] num,vis,tmp;
    static int cnt1 = 0;
    static int cnt2 = 0;
    static String[] ans;
    static void dfs(int cnt1, int cnt2, int k){
        if(k==L){
            if(cnt1 >= 1 && cnt2 >=2){
                for(int i=0;i<L;i++){
                    System.out.print(ans[i]);
                }
                System.out.println();   
            }
        }
        int st = 0;
        if(k==0){
            st = 0;
        }else{
            st = tmp[k-1];
        }
        for(int i=st;i<C;i++){
            if(vis[i] == 1) continue;
            ans[k] = arr[i];
            tmp[k] = i;
            vis[i] = 1;
            if(arr[i].equals("a") || arr[i].equals("e")  || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u") ){
                dfs(cnt1+1, cnt2, k+1);
            }else{
                dfs(cnt1, cnt2+1, k+1);
            }
            vis[i] = 0;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new String[C];
		ans = new String[C];
		tmp = new int[C+1];
		for(int i=0;i<C;i++){
		    arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		num = new int[L];
		vis = new int[C+1];
		dfs(0,0,0);
	}
}